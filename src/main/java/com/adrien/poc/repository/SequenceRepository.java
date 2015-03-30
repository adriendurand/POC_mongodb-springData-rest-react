package com.adrien.poc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.adrien.poc.bean.Sequence;

/**
 * This class is the repository for getting a sequence key from mongo database
 * 
 * @author adurand
 */
@Repository
public class SequenceRepository {

	@Autowired
	private MongoOperations mongoOperation;

	/**
	 * This method get and increment the sequence
	 * 
	 * @return the incremented id
	 * @throws Exception
	 */
	public long getNextSequenceId(String key) throws Exception {

		// get sequence id
		Query query = new Query(Criteria.where("_id").is(key));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		// return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		// this is the magic happened.
		Sequence seqId = mongoOperation.findAndModify(query, update, options, Sequence.class);

		// if no id, throws SequenceException
		// optional, just a way to tell user when the sequence id is failed to generate.
		if (seqId == null) {
			throw new Exception("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeq();
	}
}
