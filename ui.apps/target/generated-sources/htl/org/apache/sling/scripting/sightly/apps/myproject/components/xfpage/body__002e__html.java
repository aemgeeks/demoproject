/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.myproject.components.xfpage;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class body__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_body = null;
Object _global_templatedcontainer = null;
Collection var_collectionvar2_list_coerced$ = null;
_global_body = renderContext.call("use", "body.js", obj());
_global_templatedcontainer = renderContext.call("use", com.day.cq.wcm.foundation.TemplatedContainer.class.getName(), obj());
out.write("\r\n");
{
    boolean var_testvariable0 = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_templatedcontainer, "hasStructureSupport")));
    if (var_testvariable0) {
        {
            Object var_resourcecontent1 = renderContext.call("includeResource", renderContext.getObjectModel().resolveProperty(_global_body, "resourcePath"), obj().with("resourceType", "wcm/foundation/components/parsys"));
            out.write(renderContext.getObjectModel().toString(var_resourcecontent1));
        }
    }
}
out.write("\r\n<div class=\"root container\">\r\n    ");
{
    Object var_testvariable9 = renderContext.getObjectModel().resolveProperty(_global_templatedcontainer, "hasStructureSupport");
    if (renderContext.getObjectModel().toBoolean(var_testvariable9)) {
        {
            Object var_collectionvar2 = renderContext.getObjectModel().resolveProperty(_global_templatedcontainer, "structureResources");
            {
                long var_size3 = ((var_collectionvar2_list_coerced$ == null ? (var_collectionvar2_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar2)) : var_collectionvar2_list_coerced$).size());
                {
                    boolean var_notempty4 = (var_size3 > 0);
                    if (var_notempty4) {
                        {
                            long var_end7 = var_size3;
                            {
                                boolean var_validstartstepend8 = (((0 < var_size3) && true) && (var_end7 > 0));
                                if (var_validstartstepend8) {
                                    if (var_collectionvar2_list_coerced$ == null) {
                                        var_collectionvar2_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar2);
                                    }
                                    long var_index10 = 0;
                                    for (Object child : var_collectionvar2_list_coerced$) {
                                        {
                                            boolean var_traversal12 = (((var_index10 >= 0) && (var_index10 <= var_end7)) && true);
                                            if (var_traversal12) {
                                                {
                                                    Object var_resourcecontent13 = renderContext.call("includeResource", renderContext.getObjectModel().resolveProperty(child, "path"), obj().with("decorationTagName", "div").with("resourceType", renderContext.getObjectModel().resolveProperty(child, "resourceType")));
                                                    out.write(renderContext.getObjectModel().toString(var_resourcecontent13));
                                                }
                                            }
                                        }
                                        var_index10++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            var_collectionvar2_list_coerced$ = null;
        }
    }
}
out.write("\r\n</div>\r\n");
{
    Object var_resourcecontent15 = renderContext.call("includeResource", "cloudservices", obj().with("resourceType", "cq/cloudserviceconfigs/components/servicecomponents"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent15));
}
out.write("\r\n");
{
    Object var_includedresult16 = renderContext.call("include", "footerlibs.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult16));
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

