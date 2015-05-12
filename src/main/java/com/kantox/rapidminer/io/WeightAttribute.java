/**
 * Kantox LTD
 *
 * Copyright (C) 2001-2015 by Kantox LTD and the contributors
 *
 */

package com.kantox.rapidminer.io;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.table.BinominalMapping;
import com.rapidminer.example.table.DataRow;
import com.rapidminer.example.table.ExampleTable;
import com.rapidminer.example.table.NominalAttribute;
import com.rapidminer.example.table.NominalMapping;
import com.rapidminer.tools.Ontology;

/**
 * This class contains the attribute definition.
 *
 * @author Aleksei Matiushkin
 */
class WeightAttribute extends NominalAttribute { 
  private static final long serialVersionUID = 105831739884508911L;
  
  private int tableIndex;
  private Attribute attribute;
  private ExampleTable exampleTable;
  private NominalMapping nm;
  

  public WeightAttribute(String name, ExampleTable exampleTable) {
    super(name, Ontology.NOMINAL);
    this.exampleTable = exampleTable;
    tableIndex = exampleTable.getAttributeCount();
    this.attribute = exampleTable.getAttribute(1);
  }

  @Override
  public int getTableIndex() {
    return tableIndex;
  }

  @Override
  public double getValue(DataRow row) {
    return row.get(attribute);
  }

  @Override
  public int getValueType() {
    return Ontology.NOMINAL;
  }

  @Override
  public String getAsString(double value, int numberOfDigits, boolean quoteNominal) {
    return value > 0 ? "  ¡YES!" : "";
  }
  
  @Override
  public Object clone() {
    return new WeightAttribute(super.getName(), exampleTable);
  }

  @Override
  public boolean isDateTime() {
    return false;
  }

  @Override
  public NominalMapping getMapping() {
    if (nm == null) {
      nm = new BinominalMapping();
    }
    return nm;
  }

  @Override
  public void setMapping(NominalMapping nm) {
    this.nm = nm;
  }
}
