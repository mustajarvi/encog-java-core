/*
 * Encog(tm) Core v3.2 - Java Version
 * http://www.heatonresearch.com/encog/
 * http://code.google.com/p/encog-java/
 
 * Copyright 2008-2012 Heaton Research, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *   
 * For more information on Heaton Research copyrights, licenses 
 * and trademarks visit:
 * http://www.heatonresearch.com/copyright
 */
package org.encog.parse.expression;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.encog.Encog;
import org.encog.ml.prg.EncogProgram;
import org.encog.ml.prg.ExpressionError;

public class TestExpressionVar extends TestCase {
	public void testAssignment() {
		EncogProgram expression = new EncogProgram("a");
		expression.getVariables().setVariable("a",5);
		Assert.assertEquals(5,expression.evaluate().toFloatValue(),Encog.DEFAULT_DOUBLE_EQUAL);
	}
	
	public void testAssignment2() {
		EncogProgram expression = new EncogProgram("cccc*(aa+bbb)");
		expression.getVariables().setVariable("aa",1);
		expression.getVariables().setVariable("bbb",2);
		expression.getVariables().setVariable("cccc",3);
		Assert.assertEquals(9,expression.evaluate().toFloatValue(),Encog.DEFAULT_DOUBLE_EQUAL);
	}
	
	public void testError() {
		try {
			EncogProgram expression = new EncogProgram("b");
			expression.getVariables().setVariable("a", 5);
			expression.evaluate();
			Assert.assertTrue(false);
		} catch (ExpressionError ex) {
			// we want to get here
		}
	}
}
