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

package org.apache.tools.ant.taskdefs.optional;


// -- Batik classes ----------------------------------------------------------
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.apps.rasterizer.SVGConverterController;
import org.apache.batik.apps.rasterizer.SVGConverterSource;

// -- Ant classes ------------------------------------------------------------
import org.apache.tools.ant.Task;

// -- Java SDK classes -------------------------------------------------------
import java.io.File;
import java.util.Map;
import java.util.List;


/**
 * Implements simple controller for the <code>SVGConverter</code> operation.
 *
 * <p>This is almost the same as the
 * {@link org.apache.batik.apps.rasterizer.DefaultSVGConverterController DefaultSVGConverterController}
 * except this produces error message when the conversion fails.</p>
 *
 * <p>See {@link SVGConverterController} for the method documentation.</p>
 *
 * @see SVGConverterController SVGConverterController
 * @see org.apache.batik.apps.rasterizer.DefaultSVGConverterController DefaultSVGConverterController
 *
 * @author <a href="mailto:ruini@iki.fi">Henri Ruini</a>
 * @version $Id: RasterizerTaskSVGConverterController.java 479617 2006-11-27 13:43:51Z dvholten $
 */
public class RasterizerTaskSVGConverterController implements SVGConverterController {

    // -- Variables ----------------------------------------------------------
    /** Ant task that is used to log messages. */
    protected Task executingTask = null;


    // -- Constructors -------------------------------------------------------
    /**
     * Don't allow public usage.
     */
    protected RasterizerTaskSVGConverterController() {
    }

    /**
     * Sets the given Ant task to receive log messages.
     *
     * @param task Ant task. The value can be <code>null</code> when log messages won't be written.
     */
    public RasterizerTaskSVGConverterController(Task task) {
        executingTask = task;
    }


    // -- Public interface ---------------------------------------------------
    public boolean proceedWithComputedTask(Transcoder transcoder,
                                           Map hints,
                                           List sources,
                                           List dest){
        return true;
    }

    public boolean proceedWithSourceTranscoding(SVGConverterSource source,
                                                File dest) {
        return true;
    }

    public boolean proceedOnSourceTranscodingFailure(SVGConverterSource source,
                                                     File dest,
                                                     String errorCode){
        if(executingTask != null) {
            executingTask.log("Unable to rasterize image '"
                + source.getName() + "' to '"
                + dest.getAbsolutePath() + "': " + errorCode);
        }
        return true;
    }

    public void onSourceTranscodingSuccess(SVGConverterSource source,
                                           File dest){
    }

}
