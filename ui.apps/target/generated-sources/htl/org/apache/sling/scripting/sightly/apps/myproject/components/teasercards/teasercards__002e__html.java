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
package org.apache.sling.scripting.sightly.apps.myproject.components.teasercards;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class teasercards__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_teasercards = null;
Object _global_templates = null;
Collection var_collectionvar1_list_coerced$ = null;
Object _dynamic_properties = bindings.get("properties");
Collection var_collectionvar13_list_coerced$ = null;
Collection var_collectionvar25_list_coerced$ = null;
_global_teasercards = renderContext.call("use", com.myproject.aem.core.models.TeaserCard.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
out.write("\r\n<div");
{
    String var_attrcontent0 = ("container-fluid card-wrapper " + renderContext.getObjectModel().toString(renderContext.call("xss", ((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_teasercards, "list"), "size"), 1)) ? "one-treaser" : ""), "attribute")));
    out.write(" class=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent0));
    out.write("\"");
}
out.write(">\r\n\t<div class=\"cmp-big\">\r\n\t\t<div class=\"cmp-columncontrol container-fluid my-3\">\r\n\t\t\t<div class=\"row\">\r\n\t\t\t\t");
{
    Object var_collectionvar1 = renderContext.getObjectModel().resolveProperty(_global_teasercards, "list");
    {
        long var_size2 = ((var_collectionvar1_list_coerced$ == null ? (var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1)) : var_collectionvar1_list_coerced$).size());
        {
            boolean var_notempty3 = (var_size2 > 0);
            if (var_notempty3) {
                {
                    long var_end6 = var_size2;
                    {
                        boolean var_validstartstepend7 = (((0 < var_size2) && true) && (var_end6 > 0));
                        if (var_validstartstepend7) {
                            if (var_collectionvar1_list_coerced$ == null) {
                                var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1);
                            }
                            long var_index8 = 0;
                            for (Object item : var_collectionvar1_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index8, 1)).longValue());
                                    {
                                        boolean var_traversal10 = (((var_index8 >= 0) && (var_index8 <= var_end6)) && true);
                                        if (var_traversal10) {
                                            out.write("<div");
                                            {
                                                String var_attrcontent11 = (("col-md-" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "columns"), "attribute"))) + " col-sm-12");
                                                out.write(" class=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent11));
                                                out.write("\"");
                                            }
                                            out.write(">\r\n\t\t\t\t\t");
                                            {
                                                Object var_resourcecontent12 = renderContext.call("includeResource", itemlist_field$_count, obj().with("decoration", true).with("resourceType", "myproject/components/teaser"));
                                                out.write(renderContext.getObjectModel().toString(var_resourcecontent12));
                                            }
                                            out.write("\r\n\t\t\t\t</div>\n");
                                        }
                                    }
                                }
                                var_index8++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar1_list_coerced$ = null;
}
out.write("\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n\t<div class=\"cmp-small\">\r\n\t\t<div class=\"container-fluid\">\r\n\t\t\t<div class=\"row\">\r\n\t\t\t\t<div id=\"teaserCards\" class=\"carousel slide\" data-bs-touch=\"true\" data-bs-ride=\"carousel\" data-bs-pause=\"hover\">\r\n\t\t\t\t\t");
{
    Object var_collectionvar13 = renderContext.getObjectModel().resolveProperty(_global_teasercards, "list");
    {
        long var_size14 = ((var_collectionvar13_list_coerced$ == null ? (var_collectionvar13_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar13)) : var_collectionvar13_list_coerced$).size());
        {
            boolean var_notempty15 = (var_size14 > 0);
            if (var_notempty15) {
                {
                    long var_end18 = var_size14;
                    {
                        boolean var_validstartstepend19 = (((0 < var_size14) && true) && (var_end18 > 0));
                        if (var_validstartstepend19) {
                            out.write("<div class=\"carousel-inner\">");
                            if (var_collectionvar13_list_coerced$ == null) {
                                var_collectionvar13_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar13);
                            }
                            long var_index20 = 0;
                            for (Object item : var_collectionvar13_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index20, 1)).longValue());
                                    {
                                        boolean itemlist_field$_first = (var_index20 == 0);
                                        {
                                            boolean var_traversal22 = (((var_index20 >= 0) && (var_index20 <= var_end18)) && true);
                                            if (var_traversal22) {
                                                out.write("\r\n\t\t\t\t\t\t<div");
                                                {
                                                    String var_attrcontent23 = ("carousel-item " + renderContext.getObjectModel().toString(renderContext.call("xss", (itemlist_field$_first ? "active" : ""), "attribute")));
                                                    out.write(" class=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent23));
                                                    out.write("\"");
                                                }
                                                out.write(">\r\n\t\t\t\t\t\t\t<div class=\"col-11 me-3\">\r\n\t\t\t\t\t\t\t\t");
                                                {
                                                    Object var_resourcecontent24 = renderContext.call("includeResource", itemlist_field$_count, obj().with("decoration", true).with("resourceType", "myproject/components/teaser"));
                                                    out.write(renderContext.getObjectModel().toString(var_resourcecontent24));
                                                }
                                                out.write("\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t");
                                            }
                                        }
                                    }
                                }
                                var_index20++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar13_list_coerced$ = null;
}
out.write("\r\n\t\t\t\t\t");
{
    Object var_collectionvar25 = renderContext.getObjectModel().resolveProperty(_global_teasercards, "list");
    {
        long var_size26 = ((var_collectionvar25_list_coerced$ == null ? (var_collectionvar25_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar25)) : var_collectionvar25_list_coerced$).size());
        {
            boolean var_notempty27 = (var_size26 > 0);
            if (var_notempty27) {
                {
                    long var_end30 = var_size26;
                    {
                        boolean var_validstartstepend31 = (((0 < var_size26) && true) && (var_end30 > 0));
                        if (var_validstartstepend31) {
                            out.write("<div class=\"carousel-indicators\">");
                            if (var_collectionvar25_list_coerced$ == null) {
                                var_collectionvar25_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar25);
                            }
                            long var_index32 = 0;
                            for (Object item : var_collectionvar25_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index32, 1)).longValue());
                                    {
                                        long itemlist_field$_index = var_index32;
                                        {
                                            boolean itemlist_field$_first = (var_index32 == 0);
                                            {
                                                boolean var_traversal34 = (((var_index32 >= 0) && (var_index32 <= var_end30)) && true);
                                                if (var_traversal34) {
                                                    out.write("\r\n\t\t\t\t\t\t<button type=\"button\" data-bs-target=\"#teaserCards\"");
                                                    {
                                                        long var_attrvalue35 = itemlist_field$_index;
                                                        {
                                                            Object var_attrcontent36 = renderContext.call("xss", var_attrvalue35, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr38 = (((null != var_attrcontent36) && (!"".equals(var_attrcontent36))) && ((!"".equals(var_attrvalue35)) && (!((Object)false).equals(var_attrvalue35))));
                                                                if (var_shoulddisplayattr38) {
                                                                    out.write(" data-bs-slide-to");
                                                                    {
                                                                        boolean var_istrueattr37 = (((Object)var_attrvalue35).equals(true));
                                                                        if (!var_istrueattr37) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent36));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    {
                                                        String var_attrvalue39 = (itemlist_field$_first ? "active" : "");
                                                        {
                                                            Object var_attrcontent40 = renderContext.call("xss", var_attrvalue39, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr42 = (((null != var_attrcontent40) && (!"".equals(var_attrcontent40))) && ((!"".equals(var_attrvalue39)) && (!((Object)false).equals(var_attrvalue39))));
                                                                if (var_shoulddisplayattr42) {
                                                                    out.write(" class");
                                                                    {
                                                                        boolean var_istrueattr41 = (var_attrvalue39.equals(true));
                                                                        if (!var_istrueattr41) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent40));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    {
                                                        String var_attrvalue43 = (itemlist_field$_first ? "true" : "false");
                                                        {
                                                            Object var_attrcontent44 = renderContext.call("xss", var_attrvalue43, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr46 = (((null != var_attrcontent44) && (!"".equals(var_attrcontent44))) && ((!"".equals(var_attrvalue43)) && (!((Object)false).equals(var_attrvalue43))));
                                                                if (var_shoulddisplayattr46) {
                                                                    out.write(" aria-current");
                                                                    {
                                                                        boolean var_istrueattr45 = (var_attrvalue43.equals(true));
                                                                        if (!var_istrueattr45) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent44));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    {
                                                        String var_attrcontent47 = ("Slide " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                        out.write(" aria-label=\"");
                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent47));
                                                        out.write("\"");
                                                    }
                                                    out.write("></button>\r\n\t\t\t\t\t");
                                                }
                                            }
                                        }
                                    }
                                }
                                var_index32++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar25_list_coerced$ = null;
}
out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n\r\n");
{
    Object var_templatevar48 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions49_field$_isempty = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_teasercards, "list")));
        {
            java.util.Map var_templateoptions49 = obj().with("isEmpty", var_templateoptions49_field$_isempty);
            callUnit(out, renderContext, var_templatevar48, var_templateoptions49);
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

