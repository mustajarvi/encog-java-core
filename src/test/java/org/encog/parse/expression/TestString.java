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

import org.encog.ml.prg.EncogProgram;

public class TestString extends TestCase {
	public void testSimple() {
		Assert.assertEquals( "test", EncogProgram.parseString("\"test\""));
		Assert.assertEquals( "", EncogProgram.parseString("\"\""));
	}
	
	public void testConcat() {
		Assert.assertEquals( "helloworld", EncogProgram.parseString("\"hello\"+\"world\""));
		Assert.assertEquals( "test:123.0", EncogProgram.parseString("\"test:\"+123.0"));
		Assert.assertEquals( 4, (int)EncogProgram.parseFloat("length(\"test\")"));
		Assert.assertEquals( "5.22", EncogProgram.parseString("format(5.2222,2)"));
	}
}
