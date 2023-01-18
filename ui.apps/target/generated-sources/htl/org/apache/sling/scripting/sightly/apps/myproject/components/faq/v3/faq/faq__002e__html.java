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
package org.apache.sling.scripting.sightly.apps.myproject.components.faq.v3.faq;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class faq__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_faq = null;
Object _dynamic_properties = bindings.get("properties");
Collection var_collectionvar21_list_coerced$ = null;
Collection var_collectionvar36_list_coerced$ = null;
_global_faq = renderContext.call("use", com.myproject.aem.core.models.FAQModel.class.getName(), obj());
out.write("<div id=\"faqComponent\"");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "fragmentlanguage");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
            if (var_shoulddisplayattr3) {
                out.write(" data-pagelanguage");
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
out.write(" class=\"container-fluid faq-searchbox\"");
{
    Object var_attrvalue4 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "noData");
    {
        Object var_attrcontent5 = renderContext.call("xss", var_attrvalue4, "attribute");
        {
            boolean var_shoulddisplayattr7 = (((null != var_attrcontent5) && (!"".equals(var_attrcontent5))) && ((!"".equals(var_attrvalue4)) && (!((Object)false).equals(var_attrvalue4))));
            if (var_shoulddisplayattr7) {
                out.write(" data-noSuggestion");
                {
                    boolean var_istrueattr6 = (var_attrvalue4.equals(true));
                    if (!var_istrueattr6) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent5));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">\r\n    <div class=\"row g-0\">\r\n            <div class=\"col-sm-1 d-none d-sm-block col-md-2\"></div>\r\n            <div class=\"container-fluid col-md-8 col-12\">\r\n                <div class=\"row faq-search-row\">\r\n                    <div class=\"col-sm-12 col-md-6 faq-search-heading\">");
{
    String var_8 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "faqTitle"), "text")) + "\r\n                    ");
    out.write(renderContext.getObjectModel().toString(var_8));
}
out.write("</div>\r\n                    <div class=\"col-sm-12 col-md-6 faq-text-heading\">\r\n                        <p>");
{
    String var_9 = (("\r\n                            " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "subHeading"), "text"))) + "\r\n\r\n                        ");
    out.write(renderContext.getObjectModel().toString(var_9));
}
out.write("</p>\r\n                    </div>\r\n                    <div class=\"col-12 faq-search-box\">\r\n                        <div class=\"input-group input-group-sm mb-3 search_input\">\r\n                            <span class=\"input-group-addon search_symbol\" id=\"searchClick\" onclick=\"searchFaqClick()\">\r\n                                <img class=\"ms-4\" src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/faq/Vector.svg\"/>\r\n                                <img class=\"ms-4\" src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/faq/Rectangle 510.svg\"/>\r\n                            </span>\r\n                            <input type=\"text\" class=\"form-control serach_input_box faq-input-box\" style=\"border: none;\" id=\"faqSuggestions\" aria-label=\"Sizing example input\" aria-describedby=\"inputGroup-sizing-sm\"");
{
    Object var_attrvalue10 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "placeholderText");
    {
        Object var_attrcontent11 = renderContext.call("xss", var_attrvalue10, "attribute");
        {
            boolean var_shoulddisplayattr13 = (((null != var_attrcontent11) && (!"".equals(var_attrcontent11))) && ((!"".equals(var_attrvalue10)) && (!((Object)false).equals(var_attrvalue10))));
            if (var_shoulddisplayattr13) {
                out.write(" placeholder");
                {
                    boolean var_istrueattr12 = (var_attrvalue10.equals(true));
                    if (!var_istrueattr12) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent11));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" data-serachtype=\"Search-FAQ\"/>\r\n                                <div class=\"faq-product-show col-12\" id=\"faq-suggestions\">\r\n                                    <div class=\"proshow\" id=\"faqDropdown\"></div>\r\n                                </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n            <div class=\"col-sm-1 d-none d-sm-block col-md-2\"></div>\r\n    \r\n        </div>\r\n    </div>\r\n    <div class=\"container-fluid\">\r\n        <div class=\"row g-0\">\r\n            <div class=\"col-sm-1 d-none d-sm-block col-md-2\"></div>\r\n            <div class=\"col-md-8 col-12\">\r\n                <div class=\"container-fluid cmp-faq-body\">\r\n                    <div class=\"row filter-container\">\r\n                        <div class=\"button no-btn-grey-filter aem-GridColumn aem-GridColumn--default--12\">\r\n    \r\n    \r\n                            <button data-bs-toggle=\"offcanvas\" data-bs-target=\"#offcanvasRight\" aria-controls=\"offcanvasRight\" type=\"button\" id=\"filter-button-id\" class=\"btn cmp-button rounded-0 border-0\">\r\n                                <img src=\"/content/dam/myproject/button-icons/Dark-Arrow.svg\" alt=\"Button Icon\" class=\"cmp-button__icon arrow-left\"/>\r\n                                <span class=\"cmp-button__text\">");
{
    Object var_14 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterLabel"), "text");
    out.write(renderContext.getObjectModel().toString(var_14));
}
out.write("</span>\r\n                                <img src=\"/content/dam/myproject/button-icons/Dark-Arrow.svg\" alt=\"Button Icon\" class=\"cmp-button__icon arrow-right\"/>\r\n                            </button>\r\n                            <div id=\"faq-hidden-count\" class=\"d-none\"");
{
    Object var_attrvalue15 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "resultCountLabel");
    {
        Object var_attrcontent16 = renderContext.call("xss", var_attrvalue15, "attribute");
        {
            boolean var_shoulddisplayattr18 = (((null != var_attrcontent16) && (!"".equals(var_attrcontent16))) && ((!"".equals(var_attrvalue15)) && (!((Object)false).equals(var_attrvalue15))));
            if (var_shoulddisplayattr18) {
                out.write(" data-count");
                {
                    boolean var_istrueattr17 = (var_attrvalue15.equals(true));
                    if (!var_istrueattr17) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent16));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("></div>\r\n                            <div class=\"faq-result-numbers py-2\"></div>\r\n                        </div>\r\n                        <div class=\"offcanvas offcanvas-end filter-offcanvas border-0 p-0\" tabindex=\"-1\" id=\"offcanvasRight\">\r\n                            <div class=\"offcanvas-header filter-offcanvas-header\">\r\n                                <div class=\"offcanvas-header-text p-4\">\r\n                                    <div class=\"head-text-filters text-uppercase mb-4\">");
{
    Object var_19 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterPreHeading"), "text");
    out.write(renderContext.getObjectModel().toString(var_19));
}
out.write("</div>\r\n                                    <div class=\"head-text-choose\">");
{
    Object var_20 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterTitle"), "text");
    out.write(renderContext.getObjectModel().toString(var_20));
}
out.write("</div>\r\n                                </div>\r\n                                <div class=\"close-filter-button position-absolute text-center\" data-bs-dismiss=\"offcanvas\" aria-label=\"Close\"><img class=\"filter-cross-icon m-4\" src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/X.svg\" alt=\"\"/></div>\r\n                            </div>\r\n                            <div class=\"offcanvas-body\">\r\n                                <div class=\"row filter-accrodion-row\">\r\n                                    <div class=\"accordion filter-accrodion\" id=\"accordionExample\">\r\n                                        <div class=\"accordion-item filter-accrodion-item border-0\">\r\n                                            ");
{
    Object var_collectionvar21 = renderContext.getObjectModel().resolveProperty(_global_faq, "filters");
    {
        long var_size22 = ((var_collectionvar21_list_coerced$ == null ? (var_collectionvar21_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar21)) : var_collectionvar21_list_coerced$).size());
        {
            boolean var_notempty23 = (var_size22 > 0);
            if (var_notempty23) {
                {
                    long var_end26 = var_size22;
                    {
                        boolean var_validstartstepend27 = (((0 < var_size22) && true) && (var_end26 > 0));
                        if (var_validstartstepend27) {
                            if (var_collectionvar21_list_coerced$ == null) {
                                var_collectionvar21_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar21);
                            }
                            long var_index28 = 0;
                            for (Object filteritem : var_collectionvar21_list_coerced$) {
                                {
                                    long filteritemlist_field$_index = var_index28;
                                    {
                                        boolean var_traversal30 = (((var_index28 >= 0) && (var_index28 <= var_end26)) && true);
                                        if (var_traversal30) {
                                            out.write("\r\n                                                <h2 class=\"accordion-header filter-accrodion-header\"");
                                            {
                                                String var_attrcontent31 = ("heading" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" id=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent31));
                                                out.write("\"");
                                            }
                                            out.write(">\r\n                                                    <button class=\"accordion-button shadow-none text-uppercase\" type=\"button\" data-bs-toggle=\"collapse\"");
                                            {
                                                String var_attrcontent32 = ("#collapse" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" data-bs-target=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent32));
                                                out.write("\"");
                                            }
                                            out.write(" aria-expanded=\"true\" aria-controls=\"collapseOne\">");
                                            {
                                                String var_33 = (("\r\n                                                        " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(filteritem, "heading"), "text"))) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_33));
                                            }
                                            out.write("</button>\r\n                                                </h2>\r\n    \r\n    \r\n                                                <div");
                                            {
                                                String var_attrcontent34 = ("collapse" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" id=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent34));
                                                out.write("\"");
                                            }
                                            out.write(" class=\"accordion-collapse collapse show\"");
                                            {
                                                String var_attrcontent35 = ("heading" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" aria-labelledby=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent35));
                                                out.write("\"");
                                            }
                                            out.write(" data-bs-parent=\"#accordionExample\">\r\n                                                    <div class=\"accordion-body filter-accrodion-body\">\r\n                                                        <ul class=\"filter-list list-unstyled\">\r\n                                                            ");
                                            {
                                                Object var_collectionvar36 = renderContext.getObjectModel().resolveProperty(filteritem, "tagData");
                                                {
                                                    long var_size37 = ((var_collectionvar36_list_coerced$ == null ? (var_collectionvar36_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar36)) : var_collectionvar36_list_coerced$).size());
                                                    {
                                                        boolean var_notempty38 = (var_size37 > 0);
                                                        if (var_notempty38) {
                                                            {
                                                                long var_end41 = var_size37;
                                                                {
                                                                    boolean var_validstartstepend42 = (((0 < var_size37) && true) && (var_end41 > 0));
                                                                    if (var_validstartstepend42) {
                                                                        out.write("<div class=\"checkBox_list\">");
                                                                        if (var_collectionvar36_list_coerced$ == null) {
                                                                            var_collectionvar36_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar36);
                                                                        }
                                                                        long var_index43 = 0;
                                                                        for (Object tag : var_collectionvar36_list_coerced$) {
                                                                            {
                                                                                long taglist_field$_index = var_index43;
                                                                                {
                                                                                    boolean var_traversal45 = (((var_index43 >= 0) && (var_index43 <= var_end41)) && true);
                                                                                    if (var_traversal45) {
                                                                                        out.write("\r\n                                                                <ul class=\"list-group\">\r\n                                                                    <li class=\"filter-list-items\">\r\n                                                                        <div class=\"form-check filter-form-check\">\r\n                                                                            <input class=\"form-check-input form-check-input-event rounded-0 shadow-none\" type=\"checkbox\"");
                                                                                        {
                                                                                            Object var_attrvalue46 = renderContext.getObjectModel().resolveProperty(tag, "path");
                                                                                            {
                                                                                                Object var_attrcontent47 = renderContext.call("xss", var_attrvalue46, "attribute");
                                                                                                {
                                                                                                    boolean var_shoulddisplayattr49 = (((null != var_attrcontent47) && (!"".equals(var_attrcontent47))) && ((!"".equals(var_attrvalue46)) && (!((Object)false).equals(var_attrvalue46))));
                                                                                                    if (var_shoulddisplayattr49) {
                                                                                                        out.write(" value");
                                                                                                        {
                                                                                                            boolean var_istrueattr48 = (var_attrvalue46.equals(true));
                                                                                                            if (!var_istrueattr48) {
                                                                                                                out.write("=\"");
                                                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent47));
                                                                                                                out.write("\"");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        {
                                                                                            String var_attrcontent50 = (("flexCheckDefault-" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute"))) + renderContext.getObjectModel().toString(renderContext.call("xss", taglist_field$_index, "attribute")));
                                                                                            out.write(" id=\"");
                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent50));
                                                                                            out.write("\"");
                                                                                        }
                                                                                        out.write("/>\r\n                                                                            <label class=\"form-check-label\"");
                                                                                        {
                                                                                            String var_attrcontent51 = (("flexCheckDefault-" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute"))) + renderContext.getObjectModel().toString(renderContext.call("xss", taglist_field$_index, "attribute")));
                                                                                            out.write(" for=\"");
                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent51));
                                                                                            out.write("\"");
                                                                                        }
                                                                                        out.write(">");
                                                                                        {
                                                                                            String var_52 = (("\r\n                                                                                " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(tag, "title"), "text"))) + "\r\n                                                                            ");
                                                                                            out.write(renderContext.getObjectModel().toString(var_52));
                                                                                        }
                                                                                        out.write("</label>\r\n                                                                        </div>\r\n                                                                    </li>\r\n    \r\n                                                                </ul>\r\n                                                            ");
                                                                                    }
                                                                                }
                                                                            }
                                                                            var_index43++;
                                                                        }
                                                                        out.write("</div>");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                var_collectionvar36_list_coerced$ = null;
                                            }
                                            out.write("\r\n                                                        </ul>\r\n                                                    </div>\r\n                                                </div>\r\n                                            ");
                                        }
                                    }
                                }
                                var_index28++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar21_list_coerced$ = null;
}
out.write("\r\n                                        </div>\r\n    \r\n                                    </div>\r\n                                </div>\r\n                                <div class=\"row filter-buttons-row position-absolute w-100 g-0\">\r\n                                    <div class=\"col-6 p-0\">\r\n                                        <div class=\"button white-btn-filter\">\r\n                                            <button type=\"button\" id=\"clearFaqFilter\" class=\"btn cmp-button rounded-0 w-100\">\r\n                                                <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/cross.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-left\"/>\r\n                                                <span class=\"cmp-button__text \">");
{
    Object var_53 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "clearButtonLabel"), "text");
    out.write(renderContext.getObjectModel().toString(var_53));
}
out.write("</span>\r\n                                                <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/cross.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-right\"/>\r\n    \r\n                                            </button>\r\n                                        </div>\r\n                                    </div>\r\n                                    <div class=\"col-6 p-0\">\r\n                                        <div class=\"button dark-blue-btn-filter\">\r\n                                            <button data-bs-toggle=\"offcanvas\" data-bs-target=\"#offcanvasRight\" aria-controls=\"offcanvasRight\" type=\"button\" id=\"faqFilter\" class=\"btn cmp-button rounded-0 w-100\" disabled>\r\n                                                <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/tick.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-left\"/>\r\n                                                <span class=\"cmp-button__text \">");
{
    Object var_54 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterButtonLabel"), "text");
    out.write(renderContext.getObjectModel().toString(var_54));
}
out.write("</span>\r\n                                                <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/tick.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-right\"/>\r\n                                            </button>\r\n                                        </div>\r\n                                    </div>\r\n                                </div>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n                <div class=\"container-fluid faq-tabs\">\r\n                    <div class=\"accordion faq-accordion accordion-flush\" id=\"faqAccordion\"");
{
    Object var_attrvalue55 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "errorText");
    {
        Object var_attrcontent56 = renderContext.call("xss", var_attrvalue55, "attribute");
        {
            boolean var_shoulddisplayattr58 = (((null != var_attrcontent56) && (!"".equals(var_attrcontent56))) && ((!"".equals(var_attrvalue55)) && (!((Object)false).equals(var_attrvalue55))));
            if (var_shoulddisplayattr58) {
                out.write(" data-errortext");
                {
                    boolean var_istrueattr57 = (var_attrvalue55.equals(true));
                    if (!var_istrueattr57) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent56));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">                    \r\n                    </div>\r\n                </div>\r\n            </div>\r\n            <div class=\"col-sm-1 d-none d-sm-block col-md-2\"></div>\r\n    \r\n        </div>\r\n    </div>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

