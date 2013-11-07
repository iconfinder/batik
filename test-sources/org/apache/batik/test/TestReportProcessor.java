/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.apache.batik.test;

/**
 * Interface for classes that can process <tt>TestReport</tt> instances
 * This allows different applications to use the same <tt>TestReport</tt>
 * for different purposes, such as generating an XML output or
 * emailing a test result summary.
 *
 * @author <a href="mailto:vhardy@apache.org">Vincent Hardy</a>
 * @version $Id: TestReportProcessor.java 482121 2006-12-04 10:00:39Z dvholten $
 */
public interface TestReportProcessor {
    /**
     * Generic error code. Takes no parameter.
     */
    String INTERNAL_ERROR =
        "TestReportProcessor.error.code.internal.error";

    /**
     * Requests the processor to process the input
     * <tt>TestReport</tt> instances. Note that a processor
     * should make its own copy of any resource described
     * by a <tt>TestReport</tt> such as files, as these
     * may be transient resources. In particular, a
     * processor should not keep a reference to the
     * input <tt>TestReport</tt>
     */
    void processReport(TestReport report)
        throws TestException;
}


