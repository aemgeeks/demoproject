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
package org.apache.sling.scripting.sightly.apps.myproject.components.columncontrol;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class columncontrol__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_colcontrol = null;
Object _global_templates = null;
Collection var_collectionvar0_list_coerced$ = null;
_global_colcontrol = renderContext.call("use", com.myproject.aem.core.models.ColumnControl.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
out.write("<div class=\"cmp-columncontrol container my-3\">\r\n\t<div class=\"row\">\r\n\t\t");
{
    Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_colcontrol, "list");
    {
        long var_size1 = ((var_collectionvar0_list_coerced$ == null ? (var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0)) : var_collectionvar0_list_coerced$).size());
        {
            boolean var_notempty2 = (var_size1 > 0);
            if (var_notempty2) {
                {
                    long var_end5 = var_size1;
                    {
                        boolean var_validstartstepend6 = (((0 < var_size1) && true) && (var_end5 > 0));
                        if (var_validstartstepend6) {
                            if (var_collectionvar0_list_coerced$ == null) {
                                var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                            }
                            long var_index7 = 0;
                            for (Object item : var_collectionvar0_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index7, 1)).longValue());
                                    {
                                        boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                        if (var_traversal9) {
                                            out.write("<div");
                                            {
                                                String var_attrcontent10 = ((("col-md-" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_colcontrol, "columnCount"), "attribute"))) + " col-sm-12 column-") + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                out.write(" class=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent10));
                                                out.write("\"");
                                            }
                                            out.write(">\r\n\t\t\t<div class=\"column-inner\">\r\n\t\t\t\t<div class=\"column-wrapper\">");
                                            {
                                                Object var_resourcecontent11 = renderContext.call("includeResource", itemlist_field$_count, obj().with("resourceType", "myproject/components/container"));
                                                out.write(renderContext.getObjectModel().toString(var_resourcecontent11));
                                            }
                                            out.write("</div>\r\n\t\t\t</div>\r\n\t\t</div>\n");
                                        }
                                    }
                                }
                                var_index7++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar0_list_coerced$ = null;
}
out.write("\r\n\t</div>\r\n</div>\r\n");
{
    Object var_templatevar12 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions13_field$_isempty = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_colcontrol, "list")));
        {
            java.util.Map var_templateoptions13 = obj().with("isEmpty", var_templateoptions13_field$_isempty);
            callUnit(out, renderContext, var_templatevar12, var_templateoptions13);
        }
    }
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

