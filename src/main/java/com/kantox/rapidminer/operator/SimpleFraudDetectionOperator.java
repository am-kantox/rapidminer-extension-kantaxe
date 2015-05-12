/**
 * Kantox LTD
 *
 * Copyright (C) 2001-2015 by Kantox LTD and the contributors
 *
 */
package com.kantox.rapidminer.operator;

import com.kantox.rapidminer.io.BidsDataSet;
import com.kantox.rapidminer.io.BidsDataSetFactory;
import com.rapidminer.example.set.ConditionedExampleSet;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorDescription;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.ports.InputPort;
import com.rapidminer.operator.ports.OutputPort;


/**
 * A simple fraud detector.
 *
 * @author Aleksei Matiushkin
 */
public class SimpleFraudDetectionOperator extends Operator {

	/** defining the ports */
	private InputPort bidsDataInput = getInputPorts().createPort("bids", ConditionedExampleSet.class);
	private OutputPort fraudDataOutput = getOutputPorts().createPort("frauds");

	/**
	 * The default constructor needed in exactly this signature
	 *
	 * @param description
	 *            the operator description
	 */
	public SimpleFraudDetectionOperator(OperatorDescription description) {
		super(description);

		/** Adding a rule for meta data transformation: GameData will be passed through */
		getTransformer().addPassThroughRule(bidsDataInput, fraudDataOutput);
	}

	@Override
	public void doWork() throws OperatorException {
		BidsDataSet input = BidsDataSetFactory.createExampleSet(bidsDataInput.getDataOrNull(ConditionedExampleSet.class));
		detectAndMark(input);
		fraudDataOutput.deliver(input);
	}

	/**
	 * This method could extract arbitrary properties from the input data and put it as a key value
	 * pair into the KantoxFraudIOObject. Each pair will become a single attribute in the resulting
	 * ExampleSet and hence each execution of the subprocess must result in exactly the same number
	 * of pairs. Otherwise for some examples there are undefined attributes.
	 */
	private void detectAndMark(BidsDataSet input) {
		// input.setValue("Sold", 10);
	}
}
