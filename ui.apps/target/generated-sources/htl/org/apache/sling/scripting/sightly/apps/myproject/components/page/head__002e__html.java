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

public final class head__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_head = getProperty("head");
out.write("\r\n");
out.write("\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------

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
addSubTemplate("head", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _global_headlibrenderer = null;
Object _global_headresources = null;
Object _dynamic_properties = bindings.get("properties");
Object _dynamic_page = arguments.get("page");
Object _global_keywords = null;
Object _global_description = null;
Object _global_templatename = null;
Object _dynamic_pwa = arguments.get("pwa");
Object _global_clientlib = null;
Object _global_appresourcespath = null;
Collection var_collectionvar55_list_coerced$ = null;
Collection var_attrmap66_list_coerced$ = null;
Object _dynamic_environment = arguments.get("environment");
_global_headlibrenderer = renderContext.call("use", "headlibs.html", obj());
_global_headresources = renderContext.call("use", "head.resources.html", obj());
out.write("\r\n    <meta charset=\"UTF-8\"/>\r\n    <title>");
{
    String var_0 = ((renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "metaTitle"), "text")) + renderContext.getObjectModel().toString(renderContext.call("xss", (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_page, "brandSlug")) ? " | " : ""), "text"))) + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_page, "brandSlug"), "text")));
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</title>\r\n    ");
_global_keywords = renderContext.getObjectModel().resolveProperty(_dynamic_page, "keywords");
if (renderContext.getObjectModel().toBoolean(_global_keywords)) {
    out.write("<meta name=\"keywords\"");
    {
        Object var_attrvalue1 = _global_keywords;
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
    out.write("/>");
}
out.write("\r\n    ");
_global_description = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_page, "description")) ? renderContext.getObjectModel().resolveProperty(_dynamic_page, "description") : renderContext.getObjectModel().resolveProperty(_dynamic_properties, "jcr:description")));
if (renderContext.getObjectModel().toBoolean(_global_description)) {
    out.write("<meta name=\"description\"");
    {
        Object var_attrvalue5 = _global_description;
        {
            Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
            {
                boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
                if (var_shoulddisplayattr8) {
                    out.write(" content");
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
    out.write("/>");
}
out.write("\r\n    ");
_global_templatename = renderContext.getObjectModel().resolveProperty(_dynamic_page, "templateName");
if (renderContext.getObjectModel().toBoolean(_global_templatename)) {
    out.write("<meta name=\"template\"");
    {
        Object var_attrvalue9 = _global_templatename;
        {
            Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
            {
                boolean var_shoulddisplayattr12 = (((null != var_attrcontent10) && (!"".equals(var_attrcontent10))) && ((!"".equals(var_attrvalue9)) && (!((Object)false).equals(var_attrvalue9))));
                if (var_shoulddisplayattr12) {
                    out.write(" content");
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
    out.write("/>");
}
out.write("\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\r\n    ");
{
    Object var_testvariable13 = renderContext.getObjectModel().resolveProperty(_dynamic_page, "robotsTags");
    if (renderContext.getObjectModel().toBoolean(var_testvariable13)) {
        out.write("<meta name=\"robots\"");
        {
            Object var_attrvalue14 = renderContext.call("join", renderContext.getObjectModel().resolveProperty(_dynamic_page, "robotsTags"), ", ");
            {
                Object var_attrcontent15 = renderContext.call("xss", var_attrvalue14, "attribute");
                {
                    boolean var_shoulddisplayattr17 = (((null != var_attrcontent15) && (!"".equals(var_attrcontent15))) && ((!"".equals(var_attrvalue14)) && (!((Object)false).equals(var_attrvalue14))));
                    if (var_shoulddisplayattr17) {
                        out.write(" content");
                        {
                            boolean var_istrueattr16 = (var_attrvalue14.equals(true));
                            if (!var_istrueattr16) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent15));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>");
    }
}
out.write("\r\n    <meta name=\"searchLanguage\"");
{
    Object var_attrvalue18 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "language");
    {
        Object var_attrcontent19 = renderContext.call("xss", var_attrvalue18, "attribute");
        {
            boolean var_shoulddisplayattr21 = (((null != var_attrcontent19) && (!"".equals(var_attrcontent19))) && ((!"".equals(var_attrvalue18)) && (!((Object)false).equals(var_attrvalue18))));
            if (var_shoulddisplayattr21) {
                out.write(" content");
                {
                    boolean var_istrueattr20 = (var_attrvalue18.equals(true));
                    if (!var_istrueattr20) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent19));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/> \r\n\t<meta name=\"language\"");
{
    Object var_attrvalue22 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "searchlanguage");
    {
        Object var_attrcontent23 = renderContext.call("xss", var_attrvalue22, "attribute");
        {
            boolean var_shoulddisplayattr25 = (((null != var_attrcontent23) && (!"".equals(var_attrcontent23))) && ((!"".equals(var_attrvalue22)) && (!((Object)false).equals(var_attrvalue22))));
            if (var_shoulddisplayattr25) {
                out.write(" content");
                {
                    boolean var_istrueattr24 = (var_attrvalue22.equals(true));
                    if (!var_istrueattr24) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent23));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/>\r\n\r\n    ");
{
    Object var_testvariable26 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "enabled");
    if (renderContext.getObjectModel().toBoolean(var_testvariable26)) {
        out.write("\r\n        <link rel=\"manifest\"");
        {
            Object var_attrvalue27 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "manifestPath");
            {
                Object var_attrcontent28 = renderContext.call("xss", var_attrvalue27, "uri");
                {
                    boolean var_shoulddisplayattr30 = (((null != var_attrcontent28) && (!"".equals(var_attrcontent28))) && ((!"".equals(var_attrvalue27)) && (!((Object)false).equals(var_attrvalue27))));
                    if (var_shoulddisplayattr30) {
                        out.write(" href");
                        {
                            boolean var_istrueattr29 = (var_attrvalue27.equals(true));
                            if (!var_istrueattr29) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent28));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(" crossorigin=\"use-credentials\"/>\r\n        <meta name=\"theme-color\"");
        {
            Object var_attrvalue31 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "themeColor");
            {
                Object var_attrcontent32 = renderContext.call("xss", var_attrvalue31, "attribute");
                {
                    boolean var_shoulddisplayattr34 = (((null != var_attrcontent32) && (!"".equals(var_attrcontent32))) && ((!"".equals(var_attrvalue31)) && (!((Object)false).equals(var_attrvalue31))));
                    if (var_shoulddisplayattr34) {
                        out.write(" content");
                        {
                            boolean var_istrueattr33 = (var_attrvalue31.equals(true));
                            if (!var_istrueattr33) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent32));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write("/>\r\n        <link rel=\"apple-touch-icon\"");
        {
            Object var_attrvalue35 = renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "iconPath");
            {
                Object var_attrcontent36 = renderContext.call("xss", var_attrvalue35, "uri");
                {
                    boolean var_shoulddisplayattr38 = (((null != var_attrcontent36) && (!"".equals(var_attrcontent36))) && ((!"".equals(var_attrvalue35)) && (!((Object)false).equals(var_attrvalue35))));
                    if (var_shoulddisplayattr38) {
                        out.write(" href");
                        {
                            boolean var_istrueattr37 = (var_attrvalue35.equals(true));
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
        out.write("/>\r\n        ");
_global_clientlib = renderContext.call("use", "/libs/granite/sightly/templates/clientlib.html", obj());
        {
            Object var_templatevar39 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "css");
            {
                String var_templateoptions40_field$_categories = "core.wcm.components.page.v2.pwa";
                {
                    java.util.Map var_templateoptions40 = obj().with("categories", var_templateoptions40_field$_categories);
                    callUnit(out, renderContext, var_templatevar39, var_templateoptions40);
                }
            }
        }
        out.write("\r\n        <meta name=\"cq:sw_path\"");
        {
            Object var_attrvalue41 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_pwa, "serviceWorkerPath"), "text");
            {
                boolean var_shoulddisplayattr44 = ((!"".equals(var_attrvalue41)) && (!((Object)false).equals(var_attrvalue41)));
                if (var_shoulddisplayattr44) {
                    out.write(" content");
                    {
                        boolean var_istrueattr43 = (var_attrvalue41.equals(true));
                        if (!var_istrueattr43) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrvalue41));
                            out.write("\"");
                        }
                    }
                }
            }
        }
        out.write("/>\r\n    ");
    }
}
out.write("\r\n    ");
{
    Object var_includedresult45 = renderContext.call("include", "head.links.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult45));
}
out.write("\r\n    ");
{
    Object var_includedresult47 = renderContext.call("include", "head.socialmedia.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult47));
}
out.write("\r\n    ");
{
    Object var_includedresult49 = renderContext.call("include", "customheaderlibs.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult49));
}
out.write("\r\n    ");
{
    Object var_templatevar51 = renderContext.getObjectModel().resolveProperty(_global_headlibrenderer, "headlibs");
    {
        Object var_templateoptions52_field$_clientlibcategories = renderContext.getObjectModel().resolveProperty(_dynamic_page, "clientLibCategories");
        {
            Object var_templateoptions52_field$_hascloudconfigsupport = renderContext.getObjectModel().resolveProperty(_dynamic_page, "hasCloudconfigSupport");
            {
                Object var_templateoptions52_field$_clientlibcategoriesjshead = renderContext.getObjectModel().resolveProperty(_dynamic_page, "clientLibCategoriesJsHead");
                {
                    Object var_templateoptions52_field$_staticdesignpath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "staticDesignPath");
                    {
                        Object var_templateoptions52_field$_designpath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "designPath");
                        {
                            java.util.Map var_templateoptions52 = obj().with("clientLibCategories", var_templateoptions52_field$_clientlibcategories).with("hasCloudconfigSupport", var_templateoptions52_field$_hascloudconfigsupport).with("clientLibCategoriesJsHead", var_templateoptions52_field$_clientlibcategoriesjshead).with("staticDesignPath", var_templateoptions52_field$_staticdesignpath).with("designPath", var_templateoptions52_field$_designpath);
                            callUnit(out, renderContext, var_templatevar51, var_templateoptions52);
                        }
                    }
                }
            }
        }
    }
}
out.write("\r\n    ");
_global_appresourcespath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "appResourcesPath");
if (renderContext.getObjectModel().toBoolean(_global_appresourcespath)) {
    {
        Object var_templatevar53 = renderContext.getObjectModel().resolveProperty(_global_headresources, "favicons");
        {
            Object var_templateoptions54_field$_path = _global_appresourcespath;
            {
                java.util.Map var_templateoptions54 = obj().with("path", var_templateoptions54_field$_path);
                callUnit(out, renderContext, var_templatevar53, var_templateoptions54);
            }
        }
    }
}
out.write("\r\n    ");
{
    Object var_collectionvar55 = renderContext.getObjectModel().resolveProperty(_dynamic_page, "htmlPageItems");
    {
        long var_size56 = ((var_collectionvar55_list_coerced$ == null ? (var_collectionvar55_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar55)) : var_collectionvar55_list_coerced$).size());
        {
            boolean var_notempty57 = (var_size56 > 0);
            if (var_notempty57) {
                {
                    long var_end60 = var_size56;
                    {
                        boolean var_validstartstepend61 = (((0 < var_size56) && true) && (var_end60 > 0));
                        if (var_validstartstepend61) {
                            if (var_collectionvar55_list_coerced$ == null) {
                                var_collectionvar55_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar55);
                            }
                            long var_index62 = 0;
                            for (Object item : var_collectionvar55_list_coerced$) {
                                {
                                    boolean var_traversal64 = (((var_index62 >= 0) && (var_index62 <= var_end60)) && true);
                                    if (var_traversal64) {
                                        {
                                            boolean var_testvariable67 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "location"), "name"), "header"));
                                            if (var_testvariable67) {
                                                {
                                                    Object var_tagvar65 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(item, "element"), "name"), "unsafe");
                                                    if (renderContext.getObjectModel().toBoolean(var_tagvar65)) {
                                                        out.write("<");
                                                        out.write(renderContext.getObjectModel().toString(var_tagvar65));
                                                    }
                                                    if (!renderContext.getObjectModel().toBoolean(var_tagvar65)) {
                                                        out.write("<script");
                                                    }
                                                    {
                                                        Object var_attrmap66 = renderContext.getObjectModel().resolveProperty(item, "attributes");
                                                        {
                                                            java.util.Map var_ignoredattributes68 = obj();
                                                            if (var_attrmap66_list_coerced$ == null) {
                                                                var_attrmap66_list_coerced$ = renderContext.getObjectModel().toCollection(var_attrmap66);
                                                            }
                                                            long var_attrindex71 = 0;
                                                            for (Object var_attrname69 : var_attrmap66_list_coerced$) {
                                                                {
                                                                    Object var_attrnameescaped70 = renderContext.call("xss", var_attrname69, "attributeName");
                                                                    if (renderContext.getObjectModel().toBoolean(var_attrnameescaped70)) {
                                                                        {
                                                                            Object var_isignoredattr72 = var_ignoredattributes68.get(var_attrname69);
                                                                            if (!renderContext.getObjectModel().toBoolean(var_isignoredattr72)) {
                                                                                {
                                                                                    Object var_attrcontent73 = renderContext.getObjectModel().resolveProperty(var_attrmap66, var_attrname69);
                                                                                    {
                                                                                        Object var_attrcontentescaped74 = renderContext.call("xss", var_attrcontent73, "attribute", var_attrnameescaped70);
                                                                                        {
                                                                                            boolean var_shoulddisplayattr75 = (((null != var_attrcontentescaped74) && (!"".equals(var_attrcontentescaped74))) && ((!"".equals(var_attrcontent73)) && (!((Object)false).equals(var_attrcontent73))));
                                                                                            if (var_shoulddisplayattr75) {
                                                                                                out.write(" ");
                                                                                                out.write(renderContext.getObjectModel().toString(var_attrnameescaped70));
                                                                                                {
                                                                                                    boolean var_istrueattr76 = (var_attrcontent73.equals(true));
                                                                                                    if (!var_istrueattr76) {
                                                                                                        out.write("=\"");
                                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontentescaped74));
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
                                                                var_attrindex71++;
                                                            }
                                                        }
                                                        var_attrmap66_list_coerced$ = null;
                                                    }
                                                    out.write(">");
                                                    if (renderContext.getObjectModel().toBoolean(var_tagvar65)) {
                                                        out.write("</");
                                                        out.write(renderContext.getObjectModel().toString(var_tagvar65));
                                                        out.write(">");
                                                    }
                                                    if (!renderContext.getObjectModel().toBoolean(var_tagvar65)) {
                                                        out.write("</script>");
                                                    }
                                                }
                                            }
                                        }
                                        out.write("\r\n    ");
                                    }
                                }
                                var_index62++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar55_list_coerced$ = null;
}
out.write("\r\n    \r\n    \r\n    ");
{
    boolean var_testvariable77 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_environment, "environmentName"), "prod"));
    if (var_testvariable77) {
        out.write("\r\n    \t<script src=\"\" async></script>\r\n    ");
    }
}
out.write("\r\n    ");
{
    boolean var_testvariable78 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_environment, "environmentName"), "stage"));
    if (var_testvariable78) {
        out.write("\r\n    \t<script src=\"\" async></script>\r\n    ");
    }
}
out.write("\r\n    ");
{
    boolean var_testvariable79 = ((org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_environment, "environmentName"), "qa")) || (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_environment, "environmentName"), "dev")));
    if (var_testvariable79) {
        out.write("\r\n    \t<script src=\"\" async></script>\r\n    ");
    }
}
out.write("\r\n    \r\n");


// End Of Main Sub-Template Body ------------------------------------------------------------------
    }



    {
//Sub-Sub-Templates Initialization ----------------------------------------------------------------



//End of Sub-Sub-Templates Initialization ---------------------------------------------------------
    }
    
});


//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

