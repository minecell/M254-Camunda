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
 * Represents a complex data object modeling customer data.
 * The data is stored as JSON which is automatically mapped to this java
 * object by the process engine.
 *
 * @author Daniel Meyer
 *
 */
public class CustomerData {

  protected String answer1;
  protected String answer2;

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


  public String toString() {
    return "CustomerData [answer1=" + answer1 + ", answer2=" + answer2 + "]";
  }

}
