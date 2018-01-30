/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.example.usertask.embedded.serialized.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a complex data object modeling customer data. The data is stored
 * as JSON which is automatically mapped to this java object by the process
 * engine.
 *
 * @author Daniel Meyer
 *
 */
public class CustomerData {

	protected String answer1;
	protected String answer2;
	protected String answer3;
	protected int answer1points;
	protected int answer2points;
	protected int answer3points;
	protected String name;
	
	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getanswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getanswer3() {
		return answer3;
	}

	public void setanswer3(String answer3) {
		this.answer3 = answer3;
	}
/*********************************************************/
	public int getAnswer1points() {
		return answer1points;
	}

	public void setAnswer1points(int answer1points) {
		this.answer1points = answer1points;
	}

	public int getAnswer2points() {
		return answer2points;
	}

	public void setAnswer2points(int answer2points) {
		this.answer2points = answer2points;
	}

	public int getAnswer3points() {
		return answer3points;
	}

	public void setAnswer3points(int answer3points) {
		this.answer3points = answer3points;
	}
	
/*********************************************************/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "CustomerData ["+ answer1 + answer2 + answer3 + answer1points + answer2points + answer3points + name + " ]";
	}

}
