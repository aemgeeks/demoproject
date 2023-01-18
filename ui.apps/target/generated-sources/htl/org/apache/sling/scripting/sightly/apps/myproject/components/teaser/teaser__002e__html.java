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
package org.apache.sling.scripting.sightly.apps.myproject.components.teaser;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class teaser__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_teaser = null;
Object _global_templates = null;
Object _global_imagetemplate = null;
Object _global_pretitletemplate = null;
Object _global_titletemplate = null;
Object _global_descriptiontemplate = null;
Object _global_actionstemplate = null;
Object _global_hascontent = null;
Object _dynamic_wcmmode = bindings.get("wcmmode");
out.write("\r\n");
_global_teaser = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Teaser.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_imagetemplate = renderContext.call("use", "image.html", obj());
_global_pretitletemplate = renderContext.call("use", "pretitle.html", obj());
_global_titletemplate = renderContext.call("use", "title.html", obj());
_global_descriptiontemplate = renderContext.call("use", "description.html", obj());
_global_actionstemplate = renderContext.call("use", "actions.html", obj());
_global_hascontent = ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title")))) ? ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "description")))) ? ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title")))) ? ((renderContext.getObjectModel().toBoolean(((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle")))) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource")) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : renderContext.getObjectModel().resolveProperty(_global_teaser, "pretitle"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "title"))) : renderContext.getObjectModel().resolveProperty(_global_teaser, "description"))) : (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_teaser, "actions"), "size"), 0)))));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    out.write("<div");
    {
        Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_global_teaser, "id");
        {
            Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
            {
                boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
                if (var_shoulddisplayattr3) {
                    out.write(" id");
                    {
                        boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                        if (!var_istrueattr2) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    {
        String var_attrcontent4 = ("cmp-teaser" + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean((((!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "disabled"))) ? renderContext.getObjectModel().resolveProperty(_global_teaser, "imageResource") : (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "disabled")))))) ? " cq-dd-image" : ""), "attribute")));
        out.write(" class=\"");
        out.write(renderContext.getObjectModel().toString(var_attrcontent4));
        out.write("\"");
    }
    {
        Object var_attrvalue5 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_teaser, "data"), "json");
        {
            Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
            {
                boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
                if (var_shoulddisplayattr8) {
                    out.write(" data-cmp-data-layer");
                    {
                        boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                        if (!var_istrueattr7) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write(">\r\n    ");
    {
        Object var_templatevar9 = renderContext.getObjectModel().resolveProperty(_global_imagetemplate, "image");
        {
            Object var_templateoptions10_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions10 = obj().with("teaser", var_templateoptions10_field$_teaser);
                callUnit(out, renderContext, var_templatevar9, var_templateoptions10);
            }
        }
    }
    out.write("\r\n    <div class=\"cmp-teaser__content\">\r\n        ");
    {
        Object var_templatevar11 = renderContext.getObjectModel().resolveProperty(_global_pretitletemplate, "pretitle");
        {
            Object var_templateoptions12_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions12 = obj().with("teaser", var_templateoptions12_field$_teaser);
                callUnit(out, renderContext, var_templatevar11, var_templateoptions12);
            }
        }
    }
    out.write("\r\n        ");
    {
        Object var_templatevar13 = renderContext.getObjectModel().resolveProperty(_global_titletemplate, "title");
        {
            Object var_templateoptions14_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions14 = obj().with("teaser", var_templateoptions14_field$_teaser);
                callUnit(out, renderContext, var_templatevar13, var_templateoptions14);
            }
        }
    }
    out.write("\r\n        ");
    {
        Object var_templatevar15 = renderContext.getObjectModel().resolveProperty(_global_descriptiontemplate, "description");
        {
            Object var_templateoptions16_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions16 = obj().with("teaser", var_templateoptions16_field$_teaser);
                callUnit(out, renderContext, var_templatevar15, var_templateoptions16);
            }
        }
    }
    out.write("\r\n        <hr class=\"teaser-horz-line opacity-100\"/>\r\n        ");
    {
        Object var_templatevar17 = renderContext.getObjectModel().resolveProperty(_global_actionstemplate, "actions");
        {
            Object var_templateoptions18_field$_teaser = _global_teaser;
            {
                java.util.Map var_templateoptions18 = obj().with("teaser", var_templateoptions18_field$_teaser);
                callUnit(out, renderContext, var_templatevar17, var_templateoptions18);
            }
        }
    }
    out.write("\r\n        ");
    {
        Object var_resourcecontent19 = renderContext.call("includeResource", "button", obj().with("decoration", true).with("resourceType", "myproject/components/button"));
        out.write(renderContext.getObjectModel().toString(var_resourcecontent19));
    }
    out.write("\r\n    </div>\r\n</div>");
}
out.write("\r\n");
{
    Object var_templatevar20 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions21_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            String var_templateoptions21_field$_classappend = "cmp-teaser";
            {
                java.util.Map var_templateoptions21 = obj().with("isEmpty", var_templateoptions21_field$_isempty).with("classAppend", var_templateoptions21_field$_classappend);
                callUnit(out, renderContext, var_templatevar20, var_templateoptions21);
            }
        }
    }
}
out.write("\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

