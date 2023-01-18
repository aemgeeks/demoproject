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
package org.apache.sling.scripting.sightly.apps.myproject.components.breadcrumb;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class breadcrumb__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_breadcrumb = null;
Object _global_component = null;
Object _global_template = null;
Collection var_collectionvar13_list_coerced$ = null;
_global_breadcrumb = renderContext.call("use", com.myproject.aem.core.models.MyProjectBreadcrumb.class.getName(), obj());
_global_component = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Component.class.getName(), obj());
_global_template = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
{
    boolean var_testvariable0 = (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_breadcrumb, "navItems"), "size"), 0)));
    if (var_testvariable0) {
        out.write("<nav style=\"--bs-breadcrumb-divider: '>';\"");
        {
            Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_global_component, "id");
            {
                Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
                {
                    boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
                    if (var_shoulddisplayattr4) {
                        out.write(" id");
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
        out.write(" class=\"container-fluid cmp-breadcrumb-header pt-md-2\"");
        {
            Object var_attrvalue5 = renderContext.call("i18n", "Breadcrumb", obj().with("i18n", null));
            {
                Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
                {
                    boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
                    if (var_shoulddisplayattr8) {
                        out.write(" aria-label");
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
            Object var_attrvalue9 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_breadcrumb, "data"), "json");
            {
                Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
                {
                    boolean var_shoulddisplayattr12 = (((null != var_attrcontent10) && (!"".equals(var_attrcontent10))) && ((!"".equals(var_attrvalue9)) && (!((Object)false).equals(var_attrvalue9))));
                    if (var_shoulddisplayattr12) {
                        out.write(" data-cmp-data-layer");
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
        out.write(">\r\n    <div class=\"cmp-breadcrumb-empty\"></div>\r\n\t<div class=\"cmp-breadcrumb container-fluid d-none d-sm-flex d-md-flex d-lg-flex d-xl-flex d-xll-flex\">\r\n    \t");
        {
            Object var_collectionvar13 = renderContext.getObjectModel().resolveProperty(_global_breadcrumb, "navItems");
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
                                    out.write("<ol class=\"breadcrumb-list cmp-breadcrumb-list d-flex flex-wrap flex-sm-nowrap flex-md-nowrap flex-lg-nowrap flex-xl-nowrap flex-xxl-nowrap col-md-12 col-lg-12\">");
                                    if (var_collectionvar13_list_coerced$ == null) {
                                        var_collectionvar13_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar13);
                                    }
                                    long var_index20 = 0;
                                    for (Object navitem : var_collectionvar13_list_coerced$) {
                                        {
                                            long navitemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index20, 1)).longValue());
                                            {
                                                boolean var_traversal22 = (((var_index20 >= 0) && (var_index20 <= var_end18)) && true);
                                                if (var_traversal22) {
                                                    out.write("\r\n        \t<li");
                                                    {
                                                        String var_attrcontent23 = ("breadcrumb-item cmp-breadcrumb-item text-uppercase " + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(navitem, "active")) ? "active" : ""), "attribute")));
                                                        out.write(" class=\"");
                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent23));
                                                        out.write("\"");
                                                    }
                                                    {
                                                        String var_attrvalue24 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(navitem, "active")) ? "page" : "");
                                                        {
                                                            Object var_attrcontent25 = renderContext.call("xss", var_attrvalue24, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr27 = (((null != var_attrcontent25) && (!"".equals(var_attrcontent25))) && ((!"".equals(var_attrvalue24)) && (!((Object)false).equals(var_attrvalue24))));
                                                                if (var_shoulddisplayattr27) {
                                                                    out.write(" aria-current");
                                                                    {
                                                                        boolean var_istrueattr26 = (var_attrvalue24.equals(true));
                                                                        if (!var_istrueattr26) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent25));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    {
                                                        Object var_attrvalue28 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(navitem, "data"), "json");
                                                        {
                                                            Object var_attrcontent29 = renderContext.call("xss", var_attrvalue28, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr31 = (((null != var_attrcontent29) && (!"".equals(var_attrcontent29))) && ((!"".equals(var_attrvalue28)) && (!((Object)false).equals(var_attrvalue28))));
                                                                if (var_shoulddisplayattr31) {
                                                                    out.write(" data-cmp-data-layer");
                                                                    {
                                                                        boolean var_istrueattr30 = (var_attrvalue28.equals(true));
                                                                        if (!var_istrueattr30) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent29));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    out.write(">\r\n            \t");
                                                    {
                                                        Object var_unwrapcondition32 = renderContext.getObjectModel().resolveProperty(navitem, "active");
                                                        if (!renderContext.getObjectModel().toBoolean(var_unwrapcondition32)) {
                                                            out.write("<a");
                                                            {
                                                                Object var_attrvalue33 = renderContext.getObjectModel().resolveProperty(navitem, "URL");
                                                                {
                                                                    Object var_attrcontent34 = renderContext.call("xss", var_attrvalue33, "uri");
                                                                    {
                                                                        boolean var_shoulddisplayattr36 = (((null != var_attrcontent34) && (!"".equals(var_attrcontent34))) && ((!"".equals(var_attrvalue33)) && (!((Object)false).equals(var_attrvalue33))));
                                                                        if (var_shoulddisplayattr36) {
                                                                            out.write(" href");
                                                                            {
                                                                                boolean var_istrueattr35 = (var_attrvalue33.equals(true));
                                                                                if (!var_istrueattr35) {
                                                                                    out.write("=\"");
                                                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent34));
                                                                                    out.write("\"");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            {
                                                                boolean var_attrvalue37 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_breadcrumb, "data")) ? true : false);
                                                                {
                                                                    Object var_attrcontent38 = renderContext.call("xss", var_attrvalue37, "attribute");
                                                                    {
                                                                        boolean var_shoulddisplayattr40 = (((null != var_attrcontent38) && (!"".equals(var_attrcontent38))) && ((!"".equals(var_attrvalue37)) && (false != var_attrvalue37)));
                                                                        if (var_shoulddisplayattr40) {
                                                                            out.write(" data-cmp-clickable");
                                                                            {
                                                                                boolean var_istrueattr39 = (var_attrvalue37 == true);
                                                                                if (!var_istrueattr39) {
                                                                                    out.write("=\"");
                                                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent38));
                                                                                    out.write("\"");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            out.write(">");
                                                        }
                                                        {
                                                            String var_41 = (("\r\n                \t" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(navitem, "title"), "text"))) + "\r\n            \t");
                                                            out.write(renderContext.getObjectModel().toString(var_41));
                                                        }
                                                        if (!renderContext.getObjectModel().toBoolean(var_unwrapcondition32)) {
                                                            out.write("</a>");
                                                        }
                                                    }
                                                    out.write("\r\n            <meta itemprop=\"position\"");
                                                    {
                                                        long var_attrvalue42 = navitemlist_field$_count;
                                                        {
                                                            Object var_attrcontent43 = renderContext.call("xss", var_attrvalue42, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr45 = (((null != var_attrcontent43) && (!"".equals(var_attrcontent43))) && ((!"".equals(var_attrvalue42)) && (!((Object)false).equals(var_attrvalue42))));
                                                                if (var_shoulddisplayattr45) {
                                                                    out.write(" content");
                                                                    {
                                                                        boolean var_istrueattr44 = (((Object)var_attrvalue42).equals(true));
                                                                        if (!var_istrueattr44) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent43));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    out.write("/>\r\n        </li>\r\n    ");
                                                }
                                            }
                                        }
                                        var_index20++;
                                    }
                                    out.write("</ol>");
                                }
                            }
                        }
                    }
                }
            }
            var_collectionvar13_list_coerced$ = null;
        }
        out.write("\r\n</nav>");
    }
}
out.write("\r\n");
{
    Object var_templatevar46 = renderContext.getObjectModel().resolveProperty(_global_template, "placeholder");
    {
        boolean var_templateoptions47_field$_isempty = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_breadcrumb, "navItems"), "size"), 0));
        {
            String var_templateoptions47_field$_classappend = "cmp-breadcrumb";
            {
                java.util.Map var_templateoptions47 = obj().with("isEmpty", var_templateoptions47_field$_isempty).with("classAppend", var_templateoptions47_field$_classappend);
                callUnit(out, renderContext, var_templatevar46, var_templateoptions47);
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

