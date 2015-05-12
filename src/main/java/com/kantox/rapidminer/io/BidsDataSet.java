/**
 * Kantox LTD
 *
 * Copyright (C) 2001-2015 by Kantox LTD and the contributors
 *
 */

package com.kantox.rapidminer.io;

import com.rapidminer.example.Attribute;
import com.rapidminer.example.Attributes;
import com.rapidminer.example.Example;
import com.rapidminer.example.ExampleSet;
import com.rapidminer.example.table.ExampleTable;
import com.rapidminer.operator.Annotations;
import com.rapidminer.operator.IOObject;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.ports.OutputPort;
import com.rapidminer.operator.ports.ProcessingStep;
import com.rapidminer.tools.LoggingHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Float.NaN;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import javax.swing.Icon;


/**
 * This class contains the game date, recorded during runtime of the game.
 *
 * @author Sebastian Land
 */
public class BidsDataSet implements ExampleSet {
  private static final long serialVersionUID = -8239027535166935157L;
  
  private final ExampleSet data;
  
	public BidsDataSet(ExampleSet data) {
    this.data = data;
	}
  
  public BidsDataSet clone() {
    return BidsDataSetFactory.createExampleSet(this);
  }

  @Override
  public double getStatistics(Attribute attribute, String statisticsName, String statisticsParameter) {
    // return  (attribute instanceof WeightAttribute) ? // FIXME
    //  NaN : 
    return data.getStatistics(attribute, statisticsName, statisticsParameter);
  }
  
  @Override
  public double getStatistics(Attribute attribute, String statisticsName) {
    return this.getStatistics(attribute, statisticsName, null);
  }
  
  @Override
  public Attributes getAttributes() {
    return data.getAttributes();
  }

  @Override
  public int size() {
    return getExampleTable().size();
  }

  @Override
  public ExampleTable getExampleTable() {
    return data.getExampleTable();
  }

  @Override
  public Example getExample(int i) {
    return data.getExample(i);
  }

  @Override
  public Iterator<Example> iterator() {
    return data.iterator();
  }

	@Override
	public String toResultString() {
		StringBuilder builder = new StringBuilder();
		builder.append("The following values have been extracted:\n");
		builder.append("\n\nThe data: \n");
		builder.append(getExampleTable().toString());

		return builder.toString();
	}

  @Override
  public Example getExampleFromId(double d) {
    return data.getExampleFromId(d);
  }

  @Override
  public int[] getExampleIndicesFromId(double d) {
    return data.getExampleIndicesFromId(d);
  }

  @Override
  public void remapIds() {
    data.remapIds();
  }

  @Override
  public void writeDataFile(File file, int i, boolean bln, boolean bln1, boolean bln2, Charset chrst) throws IOException {
    data.writeDataFile(file, i, bln, bln1, bln2, chrst);
  }

  @Override
  public void writeAttributeFile(File file, File file1, Charset chrst) throws IOException {
    data.writeAttributeFile(file, file1, chrst);
  }

  @Override
  public void writeSparseDataFile(File file, int i, int i1, boolean bln, boolean bln1, boolean bln2, Charset chrst) throws IOException {
    data.writeSparseDataFile(file, i, i1, bln, bln1, bln2, chrst);
  }

  @Override
  public void writeSparseAttributeFile(File file, File file1, int i, Charset chrst) throws IOException {
    data.writeSparseAttributeFile(file, file1, i, chrst);
  }

  @Override
  public void recalculateAllAttributeStatistics() {
    data.recalculateAllAttributeStatistics();
  }

  @Override
  public void recalculateAttributeStatistics(Attribute atrbt) {
    data.recalculateAttributeStatistics(atrbt);
  }

  @Override
  public String getName() {
    return data.getName();
  }

  @Override
  public Icon getResultIcon() {
    return data.getResultIcon(); // FIXME
  }

  @Override
  public List getActions() {
    return data.getActions();
  }

  @Override
  public void setSource(String string) {
    data.setSource(string);
  }

  @Override
  public String getSource() {
    return data.getSource();
  }

  @Override
  public void appendOperatorToHistory(Operator oprtr, OutputPort op) {
    data.appendOperatorToHistory(oprtr, op);
  }

  @Override
  public List<ProcessingStep> getProcessingHistory() {
    return data.getProcessingHistory();
  }

  @Override
  public IOObject copy() {
    return data.copy();
  }

  @Override
  public void write(OutputStream out) throws IOException {
    data.write(out);
  }

  @Override
  public LoggingHandler getLog() {
    return data.getLog();
  }

  @Override
  public void setLoggingHandler(LoggingHandler lh) {
    data.setLoggingHandler(lh);
  }

  @Override
  public Annotations getAnnotations() {
    return data.getAnnotations();
  }

  @Override
  public Object getUserData(String string) {
    return data.getUserData(string);
  }

  @Override
  public Object setUserData(String string, Object o) {
    return data.setUserData(string, o);
  }
}
