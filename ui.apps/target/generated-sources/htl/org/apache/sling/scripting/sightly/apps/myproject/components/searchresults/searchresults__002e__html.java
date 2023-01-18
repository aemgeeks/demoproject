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
package org.apache.sling.scripting.sightly.apps.myproject.components.searchresults;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class searchresults__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_properties = bindings.get("properties");
Object _global_searchresults = null;
Collection var_collectionvar49_list_coerced$ = null;
Collection var_collectionvar64_list_coerced$ = null;
out.write("<div class=\"d-none search-text\"");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "addToDownloadLabel");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
            if (var_shoulddisplayattr3) {
                out.write(" data-addtoDownload");
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
    Object var_attrvalue4 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "readMoreLabel");
    {
        Object var_attrcontent5 = renderContext.call("xss", var_attrvalue4, "attribute");
        {
            boolean var_shoulddisplayattr7 = (((null != var_attrcontent5) && (!"".equals(var_attrcontent5))) && ((!"".equals(var_attrvalue4)) && (!((Object)false).equals(var_attrvalue4))));
            if (var_shoulddisplayattr7) {
                out.write(" data-readMore");
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
{
    Object var_attrvalue8 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "learnMoreLabel");
    {
        Object var_attrcontent9 = renderContext.call("xss", var_attrvalue8, "attribute");
        {
            boolean var_shoulddisplayattr11 = (((null != var_attrcontent9) && (!"".equals(var_attrcontent9))) && ((!"".equals(var_attrvalue8)) && (!((Object)false).equals(var_attrvalue8))));
            if (var_shoulddisplayattr11) {
                out.write(" data-learnMore");
                {
                    boolean var_istrueattr10 = (var_attrvalue8.equals(true));
                    if (!var_istrueattr10) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent9));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue12 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "watchVideoLabel");
    {
        Object var_attrcontent13 = renderContext.call("xss", var_attrvalue12, "attribute");
        {
            boolean var_shoulddisplayattr15 = (((null != var_attrcontent13) && (!"".equals(var_attrcontent13))) && ((!"".equals(var_attrvalue12)) && (!((Object)false).equals(var_attrvalue12))));
            if (var_shoulddisplayattr15) {
                out.write(" data-watchVideo");
                {
                    boolean var_istrueattr14 = (var_attrvalue12.equals(true));
                    if (!var_istrueattr14) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent13));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue16 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "noResults");
    {
        Object var_attrcontent17 = renderContext.call("xss", var_attrvalue16, "attribute");
        {
            boolean var_shoulddisplayattr19 = (((null != var_attrcontent17) && (!"".equals(var_attrcontent17))) && ((!"".equals(var_attrvalue16)) && (!((Object)false).equals(var_attrvalue16))));
            if (var_shoulddisplayattr19) {
                out.write(" data-noresults");
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
{
    Object var_attrvalue20 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "noData");
    {
        Object var_attrcontent21 = renderContext.call("xss", var_attrvalue20, "attribute");
        {
            boolean var_shoulddisplayattr23 = (((null != var_attrcontent21) && (!"".equals(var_attrcontent21))) && ((!"".equals(var_attrvalue20)) && (!((Object)false).equals(var_attrvalue20))));
            if (var_shoulddisplayattr23) {
                out.write(" data-nodata");
                {
                    boolean var_istrueattr22 = (var_attrvalue20.equals(true));
                    if (!var_istrueattr22) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent21));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("></div>\r\n\r\n\r\n<section class=\"search_results\">\r\n    <div class=\"container-fluid\">\r\n        <div class=\"row g-0\">\r\n            <div class=\"col-sm-1 d-none d-sm-block col-md-1 col-lg-1 col-xl-2 col-xxl-3\"></div>\r\n            <div class=\"col-md-10 col-12 col-lg-10 col-xl-8 col-xxl-6 justify-content-xl-center align-items-xl-center align-content-xl-center ps-xxl-3 pe-xxl-3\">\r\n                <div class=\"row g-0 cmp-search-row\">\r\n                    <div class=\"col-md-6 col-lg-6 results\">");
{
    Object var_24 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "resulttitle"), "text");
    out.write(renderContext.getObjectModel().toString(var_24));
}
out.write("</div>\r\n                    <div class=\"col-md-6 col-lg-6\">\r\n                        <div class=\"clear_serach_button pb-md-5\">\r\n                            <a class=\"clear_search text-decoration-none\" onclick=\"clearFields()\">");
{
    String var_25 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "clearSearchLabel"), "text")) + "\r\n                                ");
    out.write(renderContext.getObjectModel().toString(var_25));
}
out.write("<span class=\"clear-search-close\">\r\n                                    <img class=\"close-cross-icon ms-3\" src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/X.svg\"");
{
    Object var_attrvalue26 = renderContext.call("i18n", "close", obj().with("i18n", null));
    {
        Object var_attrcontent27 = renderContext.call("xss", var_attrvalue26, "attribute");
        {
            boolean var_shoulddisplayattr29 = (((null != var_attrcontent27) && (!"".equals(var_attrcontent27))) && ((!"".equals(var_attrvalue26)) && (!((Object)false).equals(var_attrvalue26))));
            if (var_shoulddisplayattr29) {
                out.write(" alt");
                {
                    boolean var_istrueattr28 = (var_attrvalue26.equals(true));
                    if (!var_istrueattr28) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent27));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/>\r\n                            </a>\r\n                            </span>\r\n                        </div>\r\n                    </div>\r\n\r\n                    <div class=\"row g-0\">\r\n                        <div class=\"col-md-12 col-lg-12 col-xl-12 cmp-search-inputbox-outer\">\r\n                            <div class=\"input-group input-group-sm search_input\">\r\n                                <span class=\"input-group-addon search_symbol searchClick\">\r\n                                    <span class=\"input-group-addon searchResultClickButton searchClick result-click-analytics\">\r\n                                        <img class=\"ms-4\" src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/search-icon.svg\"");
{
    Object var_attrvalue30 = renderContext.call("i18n", "searchicon", obj().with("i18n", null));
    {
        Object var_attrcontent31 = renderContext.call("xss", var_attrvalue30, "attribute");
        {
            boolean var_shoulddisplayattr33 = (((null != var_attrcontent31) && (!"".equals(var_attrcontent31))) && ((!"".equals(var_attrvalue30)) && (!((Object)false).equals(var_attrvalue30))));
            if (var_shoulddisplayattr33) {
                out.write(" alt");
                {
                    boolean var_istrueattr32 = (var_attrvalue30.equals(true));
                    if (!var_istrueattr32) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent31));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/>\r\n                                    </span>\r\n                                    <img class=\"ms-4\" src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/search-line.svg\"");
{
    Object var_attrvalue34 = renderContext.call("i18n", "searchline", obj().with("i18n", null));
    {
        Object var_attrcontent35 = renderContext.call("xss", var_attrvalue34, "attribute");
        {
            boolean var_shoulddisplayattr37 = (((null != var_attrcontent35) && (!"".equals(var_attrcontent35))) && ((!"".equals(var_attrvalue34)) && (!((Object)false).equals(var_attrvalue34))));
            if (var_shoulddisplayattr37) {
                out.write(" alt");
                {
                    boolean var_istrueattr36 = (var_attrvalue34.equals(true));
                    if (!var_istrueattr36) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent35));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write("/>\r\n                                </span>\r\n                                <input type=\"text\" id=\"search_inputbox\" class=\"form-control search_input_box search_inputbox_results search-result\" style=\"border: none;\" aria-label=\"Sizing example input\" aria-describedby=\"inputGroup-sizing-sm\"");
{
    Object var_attrvalue38 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "ghostText");
    {
        Object var_attrcontent39 = renderContext.call("xss", var_attrvalue38, "attribute");
        {
            boolean var_shoulddisplayattr41 = (((null != var_attrcontent39) && (!"".equals(var_attrcontent39))) && ((!"".equals(var_attrvalue38)) && (!((Object)false).equals(var_attrvalue38))));
            if (var_shoulddisplayattr41) {
                out.write(" placeholder");
                {
                    boolean var_istrueattr40 = (var_attrvalue38.equals(true));
                    if (!var_istrueattr40) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent39));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(" data-serachtype=\"Search-Global\" autocomplete=\"off\"/>\r\n                                <div class=\"searchProduct-show col-12\" id=\"pro-show\">\r\n                                    <div class=\"searchresshow\" id=\"proshow\"></div>\r\n                                </div>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n            <div class=\"col-sm-1 d-none d-sm-block col-md-1 col-lg-1 col-xl-2 col-xxl-3\"></div>\r\n        </div>\r\n    </div>\r\n</section>\r\n\r\n\r\n\r\n");
_global_searchresults = renderContext.call("use", com.myproject.aem.core.models.SearchResultsModel.class.getName(), obj());
out.write("<div class=\"searchresult-component container-fluid cmp-product-listing-dramix \" id=\"searchResultComponent\">\r\n    <div class=\"row g-0 filter-container\">\r\n        <div class=\"col-sm-1 d-none d-sm-block col-md-1 col-lg-1 col-xl-2 col-xxl-3\"></div>\r\n        <div class=\"col-md-10 col-12 col-lg-10 col-xl-8 col-xxl-6 ps-xxl-3 pe-xxl-3\">\r\n            <div class=\"button no-btn-grey-filter aem-GridColumn aem-GridColumn--default--12\">\r\n                <button data-bs-toggle=\"offcanvas\" data-bs-target=\"#searchresRight\" aria-controls=\"searchresRight\" type=\"button\" id=\"filter-button-id\" class=\"btn cmp-button rounded-0 border-0\">\r\n                    <img src=\"/content/dam/myproject/button-icons/Dark-Arrow.svg\" alt=\"Button Icon\" class=\"cmp-button__icon arrow-left\"/>\r\n                    <span class=\"cmp-button__text\">");
{
    String var_42 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterLabel"), "text")) + "\r\n                    ");
    out.write(renderContext.getObjectModel().toString(var_42));
}
out.write("</span>\r\n                    <img src=\"/content/dam/myproject/button-icons/Dark-Arrow.svg\" alt=\"Button Icon\" class=\"cmp-button__icon arrow-right\"/>\r\n                </button>\r\n                <div id=\"result-hidden-count\" class=\"d-none\"");
{
    Object var_attrvalue43 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "resultCountLabel");
    {
        Object var_attrcontent44 = renderContext.call("xss", var_attrvalue43, "attribute");
        {
            boolean var_shoulddisplayattr46 = (((null != var_attrcontent44) && (!"".equals(var_attrcontent44))) && ((!"".equals(var_attrvalue43)) && (!((Object)false).equals(var_attrvalue43))));
            if (var_shoulddisplayattr46) {
                out.write(" data-count");
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
out.write("></div>\r\n                <div class=\"searchresult-numbers py-2 d-flex align-items-center justify-content-center justify-content-sm-start justify-content-md-start\"></div>\r\n            </div>\r\n\r\n            <div class=\"offcanvas offcanvas-end filter-offcanvas border-0 p-0\" tabindex=\"-1\" id=\"searchresRight\">\r\n                <div class=\"offcanvas-header filter-offcanvas-header\">\r\n                    <div class=\"offcanvas-header-text p-4\">\r\n                        <div class=\"head-text-filters text-uppercase mb-4\">");
{
    Object var_47 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterPreHeading"), "text");
    out.write(renderContext.getObjectModel().toString(var_47));
}
out.write("</div>\r\n                        <div class=\"head-text-choose\">");
{
    Object var_48 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterTitle"), "text");
    out.write(renderContext.getObjectModel().toString(var_48));
}
out.write("</div>\r\n                    </div>\r\n                    <div class=\"close-filter-button position-absolute text-center\" data-bs-dismiss=\"offcanvas\" aria-label=\"Close\"><img class=\"filter-cross-icon m-4\" src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/X.svg\" alt=\"\"/>\r\n                    </div>\r\n                </div>\r\n                <div class=\"offcanvas-body\">\r\n                    <div class=\"row filter-accrodion-row\">\r\n                        <div class=\"accordion filter-accrodion\" id=\"accordionFilter\">\r\n                            <div class=\"accordion-item filter-accrodion-item border-0\">\r\n                                ");
{
    Object var_collectionvar49 = renderContext.getObjectModel().resolveProperty(_global_searchresults, "filters");
    {
        long var_size50 = ((var_collectionvar49_list_coerced$ == null ? (var_collectionvar49_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar49)) : var_collectionvar49_list_coerced$).size());
        {
            boolean var_notempty51 = (var_size50 > 0);
            if (var_notempty51) {
                {
                    long var_end54 = var_size50;
                    {
                        boolean var_validstartstepend55 = (((0 < var_size50) && true) && (var_end54 > 0));
                        if (var_validstartstepend55) {
                            if (var_collectionvar49_list_coerced$ == null) {
                                var_collectionvar49_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar49);
                            }
                            long var_index56 = 0;
                            for (Object filteritem : var_collectionvar49_list_coerced$) {
                                {
                                    long filteritemlist_field$_index = var_index56;
                                    {
                                        boolean var_traversal58 = (((var_index56 >= 0) && (var_index56 <= var_end54)) && true);
                                        if (var_traversal58) {
                                            out.write("\r\n                                    <h2 class=\"accordion-header filter-accrodion-header\"");
                                            {
                                                String var_attrcontent59 = ("heading" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" id=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent59));
                                                out.write("\"");
                                            }
                                            out.write(">\r\n                                        <button class=\"accordion-button shadow-none text-uppercase\" type=\"button\" data-bs-toggle=\"collapse\"");
                                            {
                                                String var_attrcontent60 = ("#collapse" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" data-bs-target=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent60));
                                                out.write("\"");
                                            }
                                            out.write(" aria-expanded=\"true\" aria-controls=\"collapseOne\">");
                                            {
                                                String var_61 = (("\r\n                                            " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(filteritem, "heading"), "text"))) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_61));
                                            }
                                            out.write("</button>\r\n                                    </h2>\r\n                                    <div");
                                            {
                                                String var_attrcontent62 = ("collapse" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" id=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent62));
                                                out.write("\"");
                                            }
                                            out.write(" class=\"accordion-collapse collapse show\"");
                                            {
                                                String var_attrcontent63 = ("heading" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute")));
                                                out.write(" aria-labelledby=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent63));
                                                out.write("\"");
                                            }
                                            out.write(" data-bs-parent=\"#accordionFilter\">\r\n                                        <div class=\"accordion-body filter-accrodion-body\">\r\n                                            <ul class=\"filter-list list-unstyled\">\r\n                                                ");
                                            {
                                                Object var_collectionvar64 = renderContext.getObjectModel().resolveProperty(filteritem, "tagData");
                                                {
                                                    long var_size65 = ((var_collectionvar64_list_coerced$ == null ? (var_collectionvar64_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar64)) : var_collectionvar64_list_coerced$).size());
                                                    {
                                                        boolean var_notempty66 = (var_size65 > 0);
                                                        if (var_notempty66) {
                                                            {
                                                                long var_end69 = var_size65;
                                                                {
                                                                    boolean var_validstartstepend70 = (((0 < var_size65) && true) && (var_end69 > 0));
                                                                    if (var_validstartstepend70) {
                                                                        out.write("<div class=\"checkBox_list\">");
                                                                        if (var_collectionvar64_list_coerced$ == null) {
                                                                            var_collectionvar64_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar64);
                                                                        }
                                                                        long var_index71 = 0;
                                                                        for (Object tag : var_collectionvar64_list_coerced$) {
                                                                            {
                                                                                long taglist_field$_index = var_index71;
                                                                                {
                                                                                    boolean var_traversal73 = (((var_index71 >= 0) && (var_index71 <= var_end69)) && true);
                                                                                    if (var_traversal73) {
                                                                                        out.write("\r\n                                                    <ul class=\"list-group\">\r\n                                                        <li class=\"filter-list-items\">\r\n                                                            <div class=\"form-check filter-form-check\">\r\n                                                                <input class=\"form-check-input form-check-input-event rounded-0 shadow-none\" type=\"checkbox\"");
                                                                                        {
                                                                                            Object var_attrvalue74 = renderContext.getObjectModel().resolveProperty(tag, "path");
                                                                                            {
                                                                                                Object var_attrcontent75 = renderContext.call("xss", var_attrvalue74, "attribute");
                                                                                                {
                                                                                                    boolean var_shoulddisplayattr77 = (((null != var_attrcontent75) && (!"".equals(var_attrcontent75))) && ((!"".equals(var_attrvalue74)) && (!((Object)false).equals(var_attrvalue74))));
                                                                                                    if (var_shoulddisplayattr77) {
                                                                                                        out.write(" value");
                                                                                                        {
                                                                                                            boolean var_istrueattr76 = (var_attrvalue74.equals(true));
                                                                                                            if (!var_istrueattr76) {
                                                                                                                out.write("=\"");
                                                                                                                out.write(renderContext.getObjectModel().toString(var_attrcontent75));
                                                                                                                out.write("\"");
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        {
                                                                                            String var_attrcontent78 = (("flexCheckDefault-" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute"))) + renderContext.getObjectModel().toString(renderContext.call("xss", taglist_field$_index, "attribute")));
                                                                                            out.write(" id=\"");
                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent78));
                                                                                            out.write("\"");
                                                                                        }
                                                                                        out.write("/>\r\n                                                                <label class=\"form-check-label\"");
                                                                                        {
                                                                                            String var_attrcontent79 = (("flexCheckDefault-" + renderContext.getObjectModel().toString(renderContext.call("xss", filteritemlist_field$_index, "attribute"))) + renderContext.getObjectModel().toString(renderContext.call("xss", taglist_field$_index, "attribute")));
                                                                                            out.write(" for=\"");
                                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent79));
                                                                                            out.write("\"");
                                                                                        }
                                                                                        out.write(">");
                                                                                        {
                                                                                            String var_80 = (("\r\n                                                                    " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(tag, "title"), "text"))) + "\r\n                                                                ");
                                                                                            out.write(renderContext.getObjectModel().toString(var_80));
                                                                                        }
                                                                                        out.write("</label>\r\n                                                            </div>\r\n                                                        </li>\r\n                                                    </ul>\r\n                                                ");
                                                                                    }
                                                                                }
                                                                            }
                                                                            var_index71++;
                                                                        }
                                                                        out.write("</div>");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                var_collectionvar64_list_coerced$ = null;
                                            }
                                            out.write("\r\n                                            </ul>\r\n                                        </div>\r\n                                    </div>\r\n                                ");
                                        }
                                    }
                                }
                                var_index56++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar49_list_coerced$ = null;
}
out.write("\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                    <div class=\"row filter-buttons-row position-absolute w-100 g-0\">\r\n                        <div class=\"col-6 p-0\">\r\n                            <div class=\"button white-btn-filter\">\r\n                                <button type=\"button\" id=\"clearSearchFilter\" class=\"btn cmp-button rounded-0 w-100\">\r\n                                    <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/cross.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-left\"/>\r\n                                    <span class=\"cmp-button__text \">");
{
    Object var_81 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "clearButtonLabel"), "text");
    out.write(renderContext.getObjectModel().toString(var_81));
}
out.write("</span>\r\n                                    <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/cross.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-right\"/>\r\n                                </button>\r\n                            </div>\r\n                        </div>\r\n                        <div class=\"col-6 p-0\">\r\n                            <div class=\"button dark-blue-btn-filter\">\r\n                                <button data-bs-toggle=\"offcanvas\" data-bs-target=\"#searchresFilter\" aria-controls=\"searchresFilter\" type=\"button\" id=\"searchresFilter\" data-bs-dismiss=\"offcanvas\" class=\"btn cmp-button rounded-0 w-100\" disabled>\r\n                                    <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/tick.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-left\"/>\r\n                                    <span class=\"cmp-button__text \">");
{
    Object var_82 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "filterButtonLabel"), "text");
    out.write(renderContext.getObjectModel().toString(var_82));
}
out.write("</span>\r\n                                    <img src=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/filter-icons/tick.png\" alt=\"Button Icon\" class=\"cmp-button__icon  arrow-right\"/>\r\n                                </button>\r\n                            </div>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n        <div class=\"col-sm-1 d-none d-sm-block col-md-1 col-lg-1 col-xl-2 col-xxl-3\"></div>\r\n    </div>\r\n\r\n    <div class=\"row\">\r\n        <div class=\"col-sm-1 d-none d-sm-block col-md-1 col-lg-1 col-xl-2 col-xxl-3\"></div>\r\n        <div class=\"col-md-10 col-12 col-lg-10 col-xl-8 col-xxl-6 ps-xxl-3 pe-xxl-3\">\r\n            <div class=\"searchcards-page-row mt-5 d-flex flex-wrap\"></div>\r\n        </div>\r\n        <div class=\"col-sm-1 d-none d-sm-block col-md-1 col-lg-1 col-xl-2 col-xxl-3\"></div>\r\n    </div>\r\n    <div class=\"cmp-pagination-hide pagination-row row mt-5 pt-3\">\r\n        <div class=\"pagination results-pagination listing-pagination\">\r\n            <ul class=\"justify-content-center w-100 d-flex flex-wrap\" id=\"pagination_bar\">\r\n                <!--pages or li are comes from javascript -->\r\n            </ul>\r\n        </div>\r\n    </div>\r\n</div>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

