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
package org.apache.sling.scripting.sightly.apps.myproject.components.navigation;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class navigation__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_template = null;
Object _global_navigation = null;
Object _global_hascontent = null;
Collection var_collectionvar0_list_coerced$ = null;
Object _global_hasnochildren = null;
Collection var_attrmap10_list_coerced$ = null;
Collection var_collectionvar52_list_coerced$ = null;
_global_template = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_navigation = renderContext.call("use", com.myproject.aem.core.models.MyProjectNavigation.class.getName(), obj());
_global_hascontent = (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_navigation, "navItems"), "size"), 0)));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    out.write("\r\n\t");
    {
        Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_navigation, "navItems");
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
                                out.write("<ul class=\"navbar-nav me-auto mb-xs-0 mb-sm-0 justify-content-md-center align-content-md-center align-items-md-center justify-content-lg-center align-content-lg-center align-items-lg-center justify-content-xl-center align-content-xl-center align-items-xl-center cmp-navbar\">");
                                if (var_collectionvar0_list_coerced$ == null) {
                                    var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                                }
                                long var_index7 = 0;
                                for (Object item : var_collectionvar0_list_coerced$) {
                                    {
                                        boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                        if (var_traversal9) {
                                            out.write("\r\n\t\t");
_global_hasnochildren = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "children"), "size"), 0));
                                            if (renderContext.getObjectModel().toBoolean(_global_hasnochildren)) {
                                                out.write("<li class=\"nav-item d-md-flex h-100 justify-content-md-center align-items-md-center\">\r\n\t\t\t<a");
                                                {
                                                    Object var_attrmap10 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "link"), "htmlAttributes");
                                                    {
                                                        String var_attrname_href11 = "href";
                                                        {
                                                            Object var_mapcontains_href12 = renderContext.getObjectModel().resolveProperty(var_attrmap10, "href");
                                                            {
                                                                Object var_attrcontentescaped13 = renderContext.call("xss", var_mapcontains_href12, "attribute", "href");
                                                                {
                                                                    boolean var_shoulddisplayattr14 = (((null != var_attrcontentescaped13) && (!"".equals(var_attrcontentescaped13))) && ((!"".equals(var_mapcontains_href12)) && (!((Object)false).equals(var_mapcontains_href12))));
                                                                    if (var_shoulddisplayattr14) {
                                                                        out.write(" ");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrname_href11));
                                                                        {
                                                                            boolean var_istrueattr15 = (var_mapcontains_href12.equals(true));
                                                                            if (!var_istrueattr15) {
                                                                                out.write("=\"");
                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontentescaped13));
                                                                                out.write("\"");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!renderContext.getObjectModel().toBoolean(var_mapcontains_href12)) {
                                                                {
                                                                    Object var_attrvalue16 = renderContext.getObjectModel().resolveProperty(item, "URL");
                                                                    {
                                                                        Object var_attrcontent17 = renderContext.call("xss", var_attrvalue16, "uri");
                                                                        {
                                                                            boolean var_shoulddisplayattr19 = (((null != var_attrcontent17) && (!"".equals(var_attrcontent17))) && ((!"".equals(var_attrvalue16)) && (!((Object)false).equals(var_attrvalue16))));
                                                                            if (var_shoulddisplayattr19) {
                                                                                out.write(" href");
                                                                                {
                                                                                    boolean var_istrueattr18 = (var_attrvalue16.equals(true));
                                                                                    if (!var_istrueattr18) {
                                                                                        out.write("=\"");
                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent17));
                                                                                        out.write("\"");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    {
                                                        String var_attrname_class20 = "class";
                                                        {
                                                            Object var_mapcontains_class21 = renderContext.getObjectModel().resolveProperty(var_attrmap10, "class");
                                                            {
                                                                Object var_attrcontentescaped22 = renderContext.call("xss", var_mapcontains_class21, "attribute", "class");
                                                                {
                                                                    boolean var_shoulddisplayattr23 = (((null != var_attrcontentescaped22) && (!"".equals(var_attrcontentescaped22))) && ((!"".equals(var_mapcontains_class21)) && (!((Object)false).equals(var_mapcontains_class21))));
                                                                    if (var_shoulddisplayattr23) {
                                                                        out.write(" ");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrname_class20));
                                                                        {
                                                                            boolean var_istrueattr24 = (var_mapcontains_class21.equals(true));
                                                                            if (!var_istrueattr24) {
                                                                                out.write("=\"");
                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontentescaped22));
                                                                                out.write("\"");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (!renderContext.getObjectModel().toBoolean(var_mapcontains_class21)) {
                                                                out.write(" class=\"nav-link click-contact\"");
                                                            }
                                                        }
                                                    }
                                                    out.write(" data-formaction=\"Form Viewed\" data-formid=\"contactUsForm\"");
                                                    {
                                                        Object var_attrvalue25 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(item, "current")) ? "page" : renderContext.getObjectModel().resolveProperty(item, "current")));
                                                        {
                                                            Object var_attrcontent26 = renderContext.call("xss", var_attrvalue25, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr28 = (((null != var_attrcontent26) && (!"".equals(var_attrcontent26))) && ((!"".equals(var_attrvalue25)) && (!((Object)false).equals(var_attrvalue25))));
                                                                if (var_shoulddisplayattr28) {
                                                                    out.write(" aria-current");
                                                                    {
                                                                        boolean var_istrueattr27 = (var_attrvalue25.equals(true));
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
                                                        boolean var_ignoredattributes29_field$_aria__002d__current = true;
                                                        {
                                                            boolean var_ignoredattributes29_field$_data__002d__formaction = true;
                                                            {
                                                                boolean var_ignoredattributes29_field$_href = true;
                                                                {
                                                                    boolean var_ignoredattributes29_field$_data__002d__formid = true;
                                                                    {
                                                                        boolean var_ignoredattributes29_field$_class = true;
                                                                        {
                                                                            java.util.Map var_ignoredattributes29 = obj().with("aria-current", var_ignoredattributes29_field$_aria__002d__current).with("data-formaction", var_ignoredattributes29_field$_data__002d__formaction).with("href", var_ignoredattributes29_field$_href).with("data-formid", var_ignoredattributes29_field$_data__002d__formid).with("class", var_ignoredattributes29_field$_class);
                                                                            if (var_attrmap10_list_coerced$ == null) {
                                                                                var_attrmap10_list_coerced$ = renderContext.getObjectModel().toCollection(var_attrmap10);
                                                                            }
                                                                            long var_attrindex32 = 0;
                                                                            for (Object var_attrname30 : var_attrmap10_list_coerced$) {
                                                                                {
                                                                                    Object var_attrnameescaped31 = renderContext.call("xss", var_attrname30, "attributeName");
                                                                                    if (renderContext.getObjectModel().toBoolean(var_attrnameescaped31)) {
                                                                                        {
                                                                                            Object var_isignoredattr33 = var_ignoredattributes29.get(var_attrname30);
                                                                                            if (!renderContext.getObjectModel().toBoolean(var_isignoredattr33)) {
                                                                                                {
                                                                                                    Object var_attrcontent34 = renderContext.getObjectModel().resolveProperty(var_attrmap10, var_attrname30);
                                                                                                    {
                                                                                                        Object var_attrcontentescaped35 = renderContext.call("xss", var_attrcontent34, "attribute", var_attrnameescaped31);
                                                                                                        {
                                                                                                            boolean var_shoulddisplayattr36 = (((null != var_attrcontentescaped35) && (!"".equals(var_attrcontentescaped35))) && ((!"".equals(var_attrcontent34)) && (!((Object)false).equals(var_attrcontent34))));
                                                                                                            if (var_shoulddisplayattr36) {
                                                                                                                out.write(" ");
                                                                                                                out.write(renderContext.getObjectModel().toString(var_attrnameescaped31));
                                                                                                                {
                                                                                                                    boolean var_istrueattr37 = (var_attrcontent34.equals(true));
                                                                                                                    if (!var_istrueattr37) {
                                                                                                                        out.write("=\"");
                                                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontentescaped35));
                                                                                                                        out.write("\"");
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                var_attrindex32++;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    var_attrmap10_list_coerced$ = null;
                                                }
                                                out.write(">");
                                                {
                                                    Object var_38 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_38));
                                                }
                                                out.write("</a>\r\n\t\t</li>");
                                            }
                                            out.write("\r\n\t\t");
                                            {
                                                boolean var_testvariable39 = (!renderContext.getObjectModel().toBoolean(_global_hasnochildren));
                                                if (var_testvariable39) {
                                                    out.write("<li class=\"nav-item d-md-flex h-100 justify-content-md-center align-items-md-center dropdown dropdown-hover dropdown-hover-menu position-static\">                  \r\n\t\t\t  <a");
                                                    {
                                                        Object var_attrvalue40 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(item, "addLink")) ? renderContext.getObjectModel().resolveProperty(item, "URL") : "#");
                                                        {
                                                            Object var_attrcontent41 = renderContext.call("xss", var_attrvalue40, "uri");
                                                            {
                                                                boolean var_shoulddisplayattr43 = (((null != var_attrcontent41) && (!"".equals(var_attrcontent41))) && ((!"".equals(var_attrvalue40)) && (!((Object)false).equals(var_attrvalue40))));
                                                                if (var_shoulddisplayattr43) {
                                                                    out.write(" href");
                                                                    {
                                                                        boolean var_istrueattr42 = (var_attrvalue40.equals(true));
                                                                        if (!var_istrueattr42) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent41));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    out.write(" class=\"nav-link dropdown-hover-icon dropdown-toggle dropdown-toggle-m dropdown-toggle-show menu-toolbox\"");
                                                    {
                                                        Object var_attrvalue44 = renderContext.getObjectModel().resolveProperty(item, "subSectionImage");
                                                        {
                                                            Object var_attrcontent45 = renderContext.call("xss", var_attrvalue44, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr47 = (((null != var_attrcontent45) && (!"".equals(var_attrcontent45))) && ((!"".equals(var_attrvalue44)) && (!((Object)false).equals(var_attrvalue44))));
                                                                if (var_shoulddisplayattr47) {
                                                                    out.write(" data-subsectionimage");
                                                                    {
                                                                        boolean var_istrueattr46 = (var_attrvalue44.equals(true));
                                                                        if (!var_istrueattr46) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent45));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    out.write(" role=\"button\"");
                                                    {
                                                        String var_attrcontent48 = ("mobiledropdownMenuLink" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "attribute")));
                                                        out.write(" id=\"");
                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent48));
                                                        out.write("\"");
                                                    }
                                                    out.write(" aria-expanded=\"true\">");
                                                    {
                                                        Object var_49 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "text");
                                                        out.write(renderContext.getObjectModel().toString(var_49));
                                                    }
                                                    out.write("</a>\t\t\t\r\n                  \r\n\t\t\t\t<div class=\"dropdown-menu w-100\"");
                                                    {
                                                        String var_attrcontent50 = ("mobiledropdownMenuLink" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "attribute")));
                                                        out.write(" aria-labelledby=\"");
                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent50));
                                                        out.write("\"");
                                                    }
                                                    out.write(">\r\n                \t<div class=\"container-fluid pt-md-4 mega_menu_wrapper\">\r\n                    \t<div class=\"row mt-md-5 mb-0\">\r\n                        \t<div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-3 mb-md-3 mb-xs-0 mb-lg-0\">\r\n                          \t\t<div class=\"cmp-sub-description\">");
                                                    {
                                                        String var_51 = (("\r\n                            \t\t" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "navDescription"), "text"))) + "\r\n                          \t\t");
                                                        out.write(renderContext.getObjectModel().toString(var_51));
                                                    }
                                                    out.write("</div>\r\n                        \t</div>\r\n                        \t<div class=\"col-xs-12 col-sm-6 col-md-6 col-lg-9 mb-md-3 mb-xs-0 mb-lg-0 inner-mg-menu-wrapper\">\r\n\t\t\t\t\t\t\t\t<div class=\"row\">\r\n        \t\t\t\t\t\t\t<div class=\"col-sm-4 col-md-4 col-lg-4 pt-3 pt-md-0\">\r\n\t\t\t\t\t\t\t\t\t\t");
                                                    {
                                                        boolean var_testvariable59 = (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "children"), "size"), 0)));
                                                        if (var_testvariable59) {
                                                            {
                                                                Object var_collectionvar52 = renderContext.getObjectModel().resolveProperty(item, "children");
                                                                {
                                                                    long var_size53 = ((var_collectionvar52_list_coerced$ == null ? (var_collectionvar52_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar52)) : var_collectionvar52_list_coerced$).size());
                                                                    {
                                                                        boolean var_notempty54 = (var_size53 > 0);
                                                                        if (var_notempty54) {
                                                                            {
                                                                                long var_end57 = var_size53;
                                                                                {
                                                                                    boolean var_validstartstepend58 = (((0 < var_size53) && true) && (var_end57 > 0));
                                                                                    if (var_validstartstepend58) {
                                                                                        out.write("<ul class=\"list-group list-group-flush mega-menu-wrapper ms-md-5\">");
                                                                                        if (var_collectionvar52_list_coerced$ == null) {
                                                                                            var_collectionvar52_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar52);
                                                                                        }
                                                                                        long var_index60 = 0;
                                                                                        for (Object item_1 : var_collectionvar52_list_coerced$) {
                                                                                            {
                                                                                                boolean var_traversal62 = (((var_index60 >= 0) && (var_index60 <= var_end57)) && true);
                                                                                                if (var_traversal62) {
                                                                                                    out.write("                        \r\n\t\t\t\t\t\t\t\t\t\t\t<li class=\"software-tab\">\r\n                            \t\t\t\t\t<a");
                                                                                                    {
                                                                                                        Object var_attrvalue63 = renderContext.getObjectModel().resolveProperty(item_1, "URL");
                                                                                                        {
                                                                                                            Object var_attrcontent64 = renderContext.call("xss", var_attrvalue63, "uri");
                                                                                                            {
                                                                                                                boolean var_shoulddisplayattr66 = (((null != var_attrcontent64) && (!"".equals(var_attrcontent64))) && ((!"".equals(var_attrvalue63)) && (!((Object)false).equals(var_attrvalue63))));
                                                                                                                if (var_shoulddisplayattr66) {
                                                                                                                    out.write(" href");
                                                                                                                    {
                                                                                                                        boolean var_istrueattr65 = (var_attrvalue63.equals(true));
                                                                                                                        if (!var_istrueattr65) {
                                                                                                                            out.write("=\"");
                                                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent64));
                                                                                                                            out.write("\"");
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    {
                                                                                                        Object var_attrvalue67 = renderContext.getObjectModel().resolveProperty(item_1, "subSectionImage");
                                                                                                        {
                                                                                                            Object var_attrcontent68 = renderContext.call("xss", var_attrvalue67, "attribute");
                                                                                                            {
                                                                                                                boolean var_shoulddisplayattr70 = (((null != var_attrcontent68) && (!"".equals(var_attrcontent68))) && ((!"".equals(var_attrvalue67)) && (!((Object)false).equals(var_attrvalue67))));
                                                                                                                if (var_shoulddisplayattr70) {
                                                                                                                    out.write(" data-image");
                                                                                                                    {
                                                                                                                        boolean var_istrueattr69 = (var_attrvalue67.equals(true));
                                                                                                                        if (!var_istrueattr69) {
                                                                                                                            out.write("=\"");
                                                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent68));
                                                                                                                            out.write("\"");
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    out.write(" class=\"list-group-item submenu-link\">");
                                                                                                    {
                                                                                                        Object var_71 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item_1, "title"), "text");
                                                                                                        out.write(renderContext.getObjectModel().toString(var_71));
                                                                                                    }
                                                                                                    out.write("</a>                            \r\n                            \t\t\t\t</li>\r\n\t\t\t\t\t\t\t\t\t\t");
                                                                                                }
                                                                                            }
                                                                                            var_index60++;
                                                                                        }
                                                                                        out.write("</ul>");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                var_collectionvar52_list_coerced$ = null;
                                                            }
                                                        }
                                                    }
                                                    out.write("\r\n                        \t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<div class=\"col-sm-6 col-md-6 col-lg-8\">\r\n\t\t\t\t\t\t\t\t\t\t");
                                                    {
                                                        Object var_testvariable72 = renderContext.getObjectModel().resolveProperty(item, "subSectionImage");
                                                        if (renderContext.getObjectModel().toBoolean(var_testvariable72)) {
                                                            out.write("<div class=\"cmp-megamenu-image d-none d-md-block d-sm-block d-lg-block d-xl-block d-xxl-block w-100 h-auto\">\r\n                                \t\t\t<img");
                                                            {
                                                                Object var_attrvalue73 = renderContext.getObjectModel().resolveProperty(item, "subSectionImage");
                                                                {
                                                                    Object var_attrcontent74 = renderContext.call("xss", var_attrvalue73, "uri");
                                                                    {
                                                                        boolean var_shoulddisplayattr76 = (((null != var_attrcontent74) && (!"".equals(var_attrcontent74))) && ((!"".equals(var_attrvalue73)) && (!((Object)false).equals(var_attrvalue73))));
                                                                        if (var_shoulddisplayattr76) {
                                                                            out.write(" src");
                                                                            {
                                                                                boolean var_istrueattr75 = (var_attrvalue73.equals(true));
                                                                                if (!var_istrueattr75) {
                                                                                    out.write("=\"");
                                                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent74));
                                                                                    out.write("\"");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            {
                                                                Object var_attrvalue77 = renderContext.call("i18n", "toolbox", obj().with("i18n", null));
                                                                {
                                                                    Object var_attrcontent78 = renderContext.call("xss", var_attrvalue77, "attribute");
                                                                    {
                                                                        boolean var_shoulddisplayattr80 = (((null != var_attrcontent78) && (!"".equals(var_attrcontent78))) && ((!"".equals(var_attrvalue77)) && (!((Object)false).equals(var_attrvalue77))));
                                                                        if (var_shoulddisplayattr80) {
                                                                            out.write(" alt");
                                                                            {
                                                                                boolean var_istrueattr79 = (var_attrvalue77.equals(true));
                                                                                if (!var_istrueattr79) {
                                                                                    out.write("=\"");
                                                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent78));
                                                                                    out.write("\"");
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            out.write(" class=\"img-fluid h-auto w-100\"/>\r\n                   \t\t\t\t\t\t</div>");
                                                        }
                                                    }
                                                    out.write("\r\n                        \t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</div>\r\n\t\t</li>");
                                                }
                                            }
                                            out.write("\r\n\t");
                                        }
                                    }
                                    var_index7++;
                                }
                                out.write("</ul>");
                            }
                        }
                    }
                }
            }
        }
        var_collectionvar0_list_coerced$ = null;
    }
    out.write("\r\n");
}
out.write("\r\n");
{
    Object var_templatevar81 = renderContext.getObjectModel().resolveProperty(_global_template, "placeholder");
    {
        boolean var_templateoptions82_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            java.util.Map var_templateoptions82 = obj().with("isEmpty", var_templateoptions82_field$_isempty);
            callUnit(out, renderContext, var_templatevar81, var_templateoptions82);
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

