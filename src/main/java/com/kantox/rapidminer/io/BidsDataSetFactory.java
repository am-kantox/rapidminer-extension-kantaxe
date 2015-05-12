/**
 * Kantox LTD
 *
 * Copyright (C) 2001-2015 by Kantox LTD and the contributors
 *
 */

package com.kantox.rapidminer.io;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.set.ConditionedExampleSet;
import com.rapidminer.example.table.ExampleTable;

/**
 * This class contains the game date, recorded during runtime of the game.
 *
 * @author Sebastian Land
 */
public class BidsDataSetFactory {
  
	public static final BidsDataSet createExampleSet(ConditionedExampleSet data) {
    ExampleTable exampleTable = data.getExampleTable();
    
    Attribute weight = new WeightAttribute("Fraud?", exampleTable);
    exampleTable.addAttribute(weight);
    return new BidsDataSet(exampleTable.createExampleSet(null, weight, null));
	}
  
	public static final BidsDataSet createExampleSet(BidsDataSet data) {
    return new BidsDataSet(data.getExampleTable().createExampleSet());
	}
}
