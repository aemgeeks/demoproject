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
package org.apache.sling.scripting.sightly.apps.myproject.components.button;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class button__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_button = null;
Object _global_component = null;
Object _global_icontemplate = null;
Object _global_templates = null;
Object _global_hascontent = null;
Object _dynamic_properties = bindings.get("properties");
_global_button = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Button.class.getName(), obj());
_global_component = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Component.class.getName(), obj());
_global_icontemplate = renderContext.call("use", "icon.html", obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_hascontent = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_button, "text")) ? renderContext.getObjectModel().resolveProperty(_global_button, "text") : renderContext.getObjectModel().resolveProperty(_global_button, "link")));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    {
        Object var_tagvar0 = renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_button, "link")) ? "a" : "button"), "elementName");
        if (renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("<");
            out.write(renderContext.getObjectModel().toString(var_tagvar0));
        }
        if (!renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("<button");
        }
        {
            String var_attrvalue1 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_button, "link")) ? "" : "button");
            {
                Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
                {
                    boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
                    if (var_shoulddisplayattr4) {
                        out.write(" type");
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
        {
            String var_attrvalue5 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "newTab")) ? "_blank" : "_self");
            {
                Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
                {
                    boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
                    if (var_shoulddisplayattr8) {
                        out.write(" target");
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
        {
            Object var_attrvalue9 = renderContext.getObjectModel().resolveProperty(_global_component, "id");
            {
                Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
                {
                    boolean var_shoulddisplayattr12 = (((null != var_attrcontent10) && (!"".equals(var_attrcontent10))) && ((!"".equals(var_attrvalue9)) && (!((Object)false).equals(var_attrvalue9))));
                    if (var_shoulddisplayattr12) {
                        out.write(" id");
                        {
                            boolean var_istrueattr11 = (var_attrvalue9.equals(true));
                            if (!var_istrueattr11) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent10));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(" class=\"btn cmp-button rounded-0 download-clicks\"");
        {
            Object var_attrvalue13 = renderContext.getObjectModel().resolveProperty(_global_button, "link");
            {
                Object var_attrcontent14 = renderContext.call("xss", var_attrvalue13, "uri");
                {
                    boolean var_shoulddisplayattr16 = (((null != var_attrcontent14) && (!"".equals(var_attrcontent14))) && ((!"".equals(var_attrvalue13)) && (!((Object)false).equals(var_attrvalue13))));
                    if (var_shoulddisplayattr16) {
                        out.write(" href");
                        {
                            boolean var_istrueattr15 = (var_attrvalue13.equals(true));
                            if (!var_istrueattr15) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent14));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        {
            Object var_attrvalue17 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "assetPathDownload");
            {
                Object var_attrcontent18 = renderContext.call("xss", var_attrvalue17, "attribute");
                {
                    boolean var_shoulddisplayattr20 = (((null != var_attrcontent18) && (!"".equals(var_attrcontent18))) && ((!"".equals(var_attrvalue17)) && (!((Object)false).equals(var_attrvalue17))));
                    if (var_shoulddisplayattr20) {
                        out.write(" data-assetpath");
                        {
                            boolean var_istrueattr19 = (var_attrvalue17.equals(true));
                            if (!var_istrueattr19) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent18));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        {
            Object var_attrvalue21 = renderContext.getObjectModel().resolveProperty(_global_button, "accessibilityLabel");
            {
                Object var_attrcontent22 = renderContext.call("xss", var_attrvalue21, "attribute");
                {
                    boolean var_shoulddisplayattr24 = (((null != var_attrcontent22) && (!"".equals(var_attrcontent22))) && ((!"".equals(var_attrvalue21)) && (!((Object)false).equals(var_attrvalue21))));
                    if (var_shoulddisplayattr24) {
                        out.write(" aria-label");
                        {
                            boolean var_istrueattr23 = (var_attrvalue21.equals(true));
                            if (!var_istrueattr23) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent22));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        {
            boolean var_attrvalue25 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_button, "data")) ? true : false);
            {
                Object var_attrcontent26 = renderContext.call("xss", var_attrvalue25, "attribute");
                {
                    boolean var_shoulddisplayattr28 = (((null != var_attrcontent26) && (!"".equals(var_attrcontent26))) && ((!"".equals(var_attrvalue25)) && (false != var_attrvalue25)));
                    if (var_shoulddisplayattr28) {
                        out.write(" data-cmp-clickable");
                        {
                            boolean var_istrueattr27 = (var_attrvalue25 == true);
                            if (!var_istrueattr27) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent26));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        {
            Object var_attrvalue29 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_button, "data"), "json");
            {
                Object var_attrcontent30 = renderContext.call("xss", var_attrvalue29, "attribute");
                {
                    boolean var_shoulddisplayattr32 = (((null != var_attrcontent30) && (!"".equals(var_attrcontent30))) && ((!"".equals(var_attrvalue29)) && (!((Object)false).equals(var_attrvalue29))));
                    if (var_shoulddisplayattr32) {
                        out.write(" data-cmp-data-layer");
                        {
                            boolean var_istrueattr31 = (var_attrvalue29.equals(true));
                            if (!var_istrueattr31) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent30));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(">\r\n    ");
        {
            Object var_templatevar33 = renderContext.getObjectModel().resolveProperty(_global_icontemplate, "icon");
            {
                String var_templateoptions34_field$_classname = "arrow-left";
                {
                    Object var_templateoptions34_field$_icon = renderContext.getObjectModel().resolveProperty(_global_button, "icon");
                    {
                        java.util.Map var_templateoptions34 = obj().with("classname", var_templateoptions34_field$_classname).with("icon", var_templateoptions34_field$_icon);
                        callUnit(out, renderContext, var_templatevar33, var_templateoptions34);
                    }
                }
            }
        }
        out.write("\r\n    ");
        {
            Object var_testvariable35 = renderContext.getObjectModel().resolveProperty(_global_button, "text");
            if (renderContext.getObjectModel().toBoolean(var_testvariable35)) {
                out.write("<span class=\"cmp-button__text\">");
                {
                    Object var_36 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_button, "text"), "text");
                    out.write(renderContext.getObjectModel().toString(var_36));
                }
                out.write("</span>");
            }
        }
        out.write("\r\n    ");
        {
            Object var_templatevar37 = renderContext.getObjectModel().resolveProperty(_global_icontemplate, "icon");
            {
                String var_templateoptions38_field$_classname = "arrow-right";
                {
                    Object var_templateoptions38_field$_icon = renderContext.getObjectModel().resolveProperty(_global_button, "icon");
                    {
                        java.util.Map var_templateoptions38 = obj().with("classname", var_templateoptions38_field$_classname).with("icon", var_templateoptions38_field$_icon);
                        callUnit(out, renderContext, var_templatevar37, var_templateoptions38);
                    }
                }
            }
        }
        out.write("\r\n");
        if (renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("</");
            out.write(renderContext.getObjectModel().toString(var_tagvar0));
            out.write(">");
        }
        if (!renderContext.getObjectModel().toBoolean(var_tagvar0)) {
            out.write("</button>");
        }
    }
}
out.write("\r\n");
{
    Object var_templatevar39 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions40_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            java.util.Map var_templateoptions40 = obj().with("isEmpty", var_templateoptions40_field$_isempty);
            callUnit(out, renderContext, var_templatevar39, var_templateoptions40);
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

