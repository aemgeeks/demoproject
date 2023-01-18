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
package org.apache.sling.scripting.sightly.apps.myproject.components.languagenavigation;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class languagenavigation__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_commonstemplates = null;
Object _global_languagenavigation = null;
Object _global_hascontent = null;
Collection var_collectionvar0_list_coerced$ = null;
Collection var_collectionvar12_list_coerced$ = null;
_global_commonstemplates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_languagenavigation = renderContext.call("use", com.adobe.cq.wcm.core.components.models.LanguageNavigation.class.getName(), obj());
_global_hascontent = (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_languagenavigation, "items"), "size"), 0)));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    out.write("\r\n\t\r\n<ul class=\"list-group-item cmp-language-list\">\r\n\t<li class=\"list-group-item cmp-language-order\" id=\"cmp-language\">\r\n\t");
    {
        Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_languagenavigation, "items");
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
                                        boolean itemlist_field$_first = (var_index7 == 0);
                                        {
                                            boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                            if (var_traversal9) {
                                                out.write("\t\t\r\n\t\t");
                                                {
                                                    boolean var_testvariable10 = itemlist_field$_first;
                                                    if (var_testvariable10) {
                                                        out.write("<span class=\"cmp-language-selected language-append\">");
                                                        {
                                                            Object var_11 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "text");
                                                            out.write(renderContext.getObjectModel().toString(var_11));
                                                        }
                                                        out.write("</span>");
                                                    }
                                                }
                                                out.write(" \t\t\r\n\t");
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
    out.write(" \r\n\t\t");
    {
        Object var_collectionvar12 = renderContext.getObjectModel().resolveProperty(_global_languagenavigation, "items");
        {
            long var_size13 = ((var_collectionvar12_list_coerced$ == null ? (var_collectionvar12_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar12)) : var_collectionvar12_list_coerced$).size());
            {
                boolean var_notempty14 = (var_size13 > 0);
                if (var_notempty14) {
                    {
                        long var_end17 = var_size13;
                        {
                            boolean var_validstartstepend18 = (((0 < var_size13) && true) && (var_end17 > 0));
                            if (var_validstartstepend18) {
                                out.write("<ul class=\"list-group cmp-language-list-menu\">");
                                if (var_collectionvar12_list_coerced$ == null) {
                                    var_collectionvar12_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar12);
                                }
                                long var_index19 = 0;
                                for (Object item : var_collectionvar12_list_coerced$) {
                                    {
                                        boolean var_traversal21 = (((var_index19 >= 0) && (var_index19 <= var_end17)) && true);
                                        if (var_traversal21) {
                                            out.write("\r\n\t\t\t<li class=\"cmp-langauage-list-val\"><a class=\"list-group-item language-selection\"");
                                            {
                                                Object var_attrvalue22 = renderContext.getObjectModel().resolveProperty(item, "URL");
                                                {
                                                    Object var_attrcontent23 = renderContext.call("xss", var_attrvalue22, "uri");
                                                    {
                                                        boolean var_shoulddisplayattr25 = (((null != var_attrcontent23) && (!"".equals(var_attrcontent23))) && ((!"".equals(var_attrvalue22)) && (!((Object)false).equals(var_attrvalue22))));
                                                        if (var_shoulddisplayattr25) {
                                                            out.write(" href");
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
                                            out.write(">");
                                            {
                                                Object var_26 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_26));
                                            }
                                            out.write("</a></li>\r\n\t\t");
                                        }
                                    }
                                    var_index19++;
                                }
                                out.write("</ul>");
                            }
                        }
                    }
                }
            }
        }
        var_collectionvar12_list_coerced$ = null;
    }
    out.write("     \r\n\r\n\t</li>                        \r\n</ul>\r\n\r\n");
}
out.write("\r\n\r\n");
{
    Object var_templatevar27 = renderContext.getObjectModel().resolveProperty(_global_commonstemplates, "placeholder");
    {
        boolean var_templateoptions28_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            java.util.Map var_templateoptions28 = obj().with("isEmpty", var_templateoptions28_field$_isempty);
            callUnit(out, renderContext, var_templatevar27, var_templateoptions28);
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

