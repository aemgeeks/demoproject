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
package org.apache.sling.scripting.sightly.apps.myproject.components.page;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class ogtags__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_extmodel = null;
Object _dynamic_properties = bindings.get("properties");
Object _dynamic_inheritedpageproperties = bindings.get("inheritedpageproperties");
_global_extmodel = renderContext.call("use", com.myproject.aem.core.models.ExternalizerConfigData.class.getName(), obj());
out.write("\r\n");
{
    boolean var_testvariable0 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ogtagscheck"), "yes"));
    if (var_testvariable0) {
        out.write("\r\n\r\n<meta property=\"og:url\"");
        {
            Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_global_extmodel, "externalLink");
            {
                Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
                {
                    boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
                    if (var_shoulddisplayattr4) {
                        out.write(" content");
                        {
                            boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                            if (!var_istrueattr3) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent2));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(" x-cq-linkchecker=\"skip\"/>\r\n<meta property=\"og:type\" content=\"website\"/>\r\n<meta property=\"og:site_name\" content=\"Bekaert Dramix\u00AE\"/>\r\n<meta property=\"og:title\"");
        {
            String var_attrcontent5 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ogtitle"), "attribute")) + " ");
            out.write(" content=\"");
            out.write(renderContext.getObjectModel().toString(var_attrcontent5));
            out.write("\"");
        }
        out.write("/>\r\n<meta property=\"og:description\"");
        {
            String var_attrcontent6 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ogdescription"), "attribute")) + " ");
            out.write(" content=\"");
            out.write(renderContext.getObjectModel().toString(var_attrcontent6));
            out.write("\"");
        }
        out.write("/>\r\n");
        {
            Object var_testvariable7 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ogImage")) ? renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ogImage") : renderContext.getObjectModel().resolveProperty(_dynamic_inheritedpageproperties, "ogImage")));
            if (renderContext.getObjectModel().toBoolean(var_testvariable7)) {
                out.write("\r\n\t<meta property=\"og:image\"");
                {
                    String var_attrcontent8 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_extmodel, "domainName"), "attribute")) + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ogImage")) ? renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ogImage") : renderContext.getObjectModel().resolveProperty(_dynamic_inheritedpageproperties, "ogImage")), "attribute")));
                    out.write(" content=\"");
                    out.write(renderContext.getObjectModel().toString(var_attrcontent8));
                    out.write("\"");
                }
                out.write("/>\r\n");
            }
        }
        out.write("\r\n\r\n");
    }
}
out.write("\r\n\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

