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
package org.apache.sling.scripting.sightly.apps.myproject.components.solutioncomponent;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class solutioncomponent__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_solution = null;
Object _global_templates = null;
Object _dynamic_properties = bindings.get("properties");
Collection var_collectionvar2_list_coerced$ = null;
Collection var_collectionvar23_list_coerced$ = null;
Collection var_collectionvar36_list_coerced$ = null;
Collection var_collectionvar68_list_coerced$ = null;
out.write("\r\n");
_global_solution = renderContext.call("use", com.myproject.aem.core.models.SolutionComponent.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
out.write("<div class=\"container-dramix container-fluid\">\r\n  <div class=\"row solution-row\">\r\n    <div class=\"col-lg-6 col-sm-12 p-0 grey-background\">\r\n      <div class=\"col-sm-12 cmp-left\">\r\n        <div class=\"solution-div\">\r\n          <div class=\"head-text-solutions text-uppercase pb-2\">");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "heading"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\r\n          <p class=\"cmp-solution-title\">");
{
    Object var_1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</p>\r\n        </div>\r\n      </div>\r\n    </div>\r\n    <div class=\"col-lg-6 col-sm-12 p-0\">\r\n      <div class=\"image-bg-div w-100\" style=\"background-image:none\">\r\n        ");
{
    Object var_collectionvar2 = renderContext.getObjectModel().resolveProperty(_global_solution, "solutionList");
    {
        long var_size3 = ((var_collectionvar2_list_coerced$ == null ? (var_collectionvar2_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar2)) : var_collectionvar2_list_coerced$).size());
        {
            boolean var_notempty4 = (var_size3 > 0);
            if (var_notempty4) {
                {
                    long var_end7 = var_size3;
                    {
                        boolean var_validstartstepend8 = (((0 < var_size3) && true) && (var_end7 > 0));
                        if (var_validstartstepend8) {
                            out.write("<div class=\"stairs-img-text position-relative\">");
                            if (var_collectionvar2_list_coerced$ == null) {
                                var_collectionvar2_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar2);
                            }
                            long var_index9 = 0;
                            for (Object item : var_collectionvar2_list_coerced$) {
                                {
                                    boolean itemlist_field$_last = (var_index9 == (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.SUB.eval(var_size3, 1)).longValue()));
                                    {
                                        boolean var_traversal11 = (((var_index9 >= 0) && (var_index9 <= var_end7)) && true);
                                        if (var_traversal11) {
                                            out.write("\r\n          <div class=\"head-text-softwares text-uppercase mb-4\">");
                                            {
                                                Object var_12 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "heading"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_12));
                                            }
                                            out.write("</div>\r\n          <a");
                                            {
                                                Object var_attrvalue13 = renderContext.call("uriManipulation", renderContext.getObjectModel().resolveProperty(item, "link"), obj().with("extension", "html"));
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
                                                String var_attrvalue17 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(item, "newTab")) ? "_blank" : "_self");
                                                {
                                                    Object var_attrcontent18 = renderContext.call("xss", var_attrvalue17, "attribute");
                                                    {
                                                        boolean var_shoulddisplayattr20 = (((null != var_attrcontent18) && (!"".equals(var_attrcontent18))) && ((!"".equals(var_attrvalue17)) && (!((Object)false).equals(var_attrvalue17))));
                                                        if (var_shoulddisplayattr20) {
                                                            out.write(" target");
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
                                            out.write(" class=\"stairs-text-content-link text-decoration-none\">\r\n            <div class=\"stairs-text-content\">");
                                            {
                                                String var_21 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "description"), "text")) + "\r\n              ");
                                                out.write(renderContext.getObjectModel().toString(var_21));
                                            }
                                            out.write("<svg class=\"arrow-stairs\" width=\"12\" height=\"20\" viewBox=\"0 0 12 20\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">\r\n                <path d=\"M2 1.5L9.5 10.5L2 19\" stroke=\"white\" stroke-width=\"3\"/>\r\n              </svg>\r\n            </div>\r\n          </a>\r\n          ");
                                            {
                                                boolean var_testvariable22 = (!itemlist_field$_last);
                                                if (var_testvariable22) {
                                                    out.write("<svg width=\"320\" height=\"1\" class=\"stairs-divide-line my-4\" viewBox=\"0 0 320 1\" fill=\"none\" xmlns=\"http://www.w3.org/2000/svg\">\r\n            <rect opacity=\"0.2\" x=\"320\" width=\"1.00001\" height=\"320\" transform=\"rotate(90 320 0)\" fill=\"white\"/>\r\n          </svg>");
                                                }
                                            }
                                            out.write("\r\n        ");
                                        }
                                    }
                                }
                                var_index9++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar2_list_coerced$ = null;
}
out.write("\r\n      </div>\r\n    </div>\r\n  </div>\r\n  <div class=\"section-solution d-none d-lg-block\">\r\n    <div class=\"container\">\r\n      <div class=\"row solution-row\">\r\n        <div class=\"col-lg-6 col-sm-12  p-0\">\r\n          ");
{
    Object var_collectionvar23 = renderContext.getObjectModel().resolveProperty(_global_solution, "challengeList");
    {
        long var_size24 = ((var_collectionvar23_list_coerced$ == null ? (var_collectionvar23_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar23)) : var_collectionvar23_list_coerced$).size());
        {
            boolean var_notempty25 = (var_size24 > 0);
            if (var_notempty25) {
                {
                    long var_end28 = var_size24;
                    {
                        boolean var_validstartstepend29 = (((0 < var_size24) && true) && (var_end28 > 0));
                        if (var_validstartstepend29) {
                            if (var_collectionvar23_list_coerced$ == null) {
                                var_collectionvar23_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar23);
                            }
                            long var_index30 = 0;
                            for (Object item : var_collectionvar23_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index30, 1)).longValue());
                                    {
                                        boolean var_traversal32 = (((var_index30 >= 0) && (var_index30 <= var_end28)) && true);
                                        if (var_traversal32) {
                                            out.write("<div class=\"challenge-card-link position-relative text-decoration-none\">\r\n            <div class=\"challenges-card float-end position-relative\" id=\"challenge-card-id\"");
                                            {
                                                String var_attrcontent33 = ("Section" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                out.write(" data-id=\"");
                                                out.write(renderContext.getObjectModel().toString(var_attrcontent33));
                                                out.write("\"");
                                            }
                                            out.write(">\r\n              <div class=\"challenge-head text-uppercase py-4 px-5\">");
                                            {
                                                Object var_34 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "heading"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_34));
                                            }
                                            out.write("</div>\r\n              <div class=\"challenge-text pb-4 px-5\">");
                                            {
                                                Object var_35 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_35));
                                            }
                                            out.write("</div>\r\n            </div>\r\n          </div>\n");
                                        }
                                    }
                                }
                                var_index30++;
                            }
                        }
                    }
                }
            }
        }
    }
    var_collectionvar23_list_coerced$ = null;
}
out.write("\r\n        </div>\r\n        ");
{
    Object var_collectionvar36 = renderContext.getObjectModel().resolveProperty(_global_solution, "challengeList");
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
                            out.write("<div class=\"col-lg-6 col-sm-12  p-0 cmp-card-col\">");
                            if (var_collectionvar36_list_coerced$ == null) {
                                var_collectionvar36_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar36);
                            }
                            long var_index43 = 0;
                            for (Object item : var_collectionvar36_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index43, 1)).longValue());
                                    {
                                        boolean itemlist_field$_first = (var_index43 == 0);
                                        {
                                            boolean var_traversal45 = (((var_index43 >= 0) && (var_index43 <= var_end41)) && true);
                                            if (var_traversal45) {
                                                out.write("\r\n          <div class=\"cmp-card-cont position-relative h-100\"");
                                                {
                                                    String var_attrcontent46 = ("content-" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                    out.write(" data-content=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent46));
                                                    out.write("\"");
                                                }
                                                {
                                                    String var_attrcontent47 = ("Section" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                    out.write(" id=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent47));
                                                    out.write("\"");
                                                }
                                                {
                                                    String var_attrcontent48 = ("display:" + renderContext.getObjectModel().toString(renderContext.call("xss", (itemlist_field$_first ? "block" : "none"), "styleString")));
                                                    out.write(" style=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent48));
                                                    out.write("\"");
                                                }
                                                out.write(">\r\n            <div class=\"cmp-card-wrapper align-items-center h-100 d-flex p-3 animate__animated animate__fadeInUpBig\">\r\n              <div class=\"cmp-card-inner\">\r\n                <h4>");
                                                {
                                                    Object var_49 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "subHeading"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_49));
                                                }
                                                out.write("</h4>\r\n                <p>");
                                                {
                                                    Object var_50 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "description"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_50));
                                                }
                                                out.write("</p>\r\n                <div class=\"cmp-box-button\">\r\n                  <div class=\"button dark-btn-grey\">\r\n                    <a");
                                                {
                                                    Object var_attrvalue51 = renderContext.call("uriManipulation", renderContext.getObjectModel().resolveProperty(item, "buttonUrl"), obj().with("extension", "html"));
                                                    {
                                                        Object var_attrcontent52 = renderContext.call("xss", var_attrvalue51, "uri");
                                                        {
                                                            boolean var_shoulddisplayattr54 = (((null != var_attrcontent52) && (!"".equals(var_attrcontent52))) && ((!"".equals(var_attrvalue51)) && (!((Object)false).equals(var_attrvalue51))));
                                                            if (var_shoulddisplayattr54) {
                                                                out.write(" href");
                                                                {
                                                                    boolean var_istrueattr53 = (var_attrvalue51.equals(true));
                                                                    if (!var_istrueattr53) {
                                                                        out.write("=\"");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent52));
                                                                        out.write("\"");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                {
                                                    String var_attrvalue55 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(item, "newTab")) ? "_blank" : "_self");
                                                    {
                                                        Object var_attrcontent56 = renderContext.call("xss", var_attrvalue55, "attribute");
                                                        {
                                                            boolean var_shoulddisplayattr58 = (((null != var_attrcontent56) && (!"".equals(var_attrcontent56))) && ((!"".equals(var_attrvalue55)) && (!((Object)false).equals(var_attrvalue55))));
                                                            if (var_shoulddisplayattr58) {
                                                                out.write(" target");
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
                                                out.write(" type=\"button\" id=\"button-80b69e4142\" class=\"btn cmp-button rounded-0\">\r\n                        <img");
                                                {
                                                    Object var_attrvalue59 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonIcon");
                                                    {
                                                        Object var_attrcontent60 = renderContext.call("xss", var_attrvalue59, "uri");
                                                        {
                                                            boolean var_shoulddisplayattr62 = (((null != var_attrcontent60) && (!"".equals(var_attrcontent60))) && ((!"".equals(var_attrvalue59)) && (!((Object)false).equals(var_attrvalue59))));
                                                            if (var_shoulddisplayattr62) {
                                                                out.write(" src");
                                                                {
                                                                    boolean var_istrueattr61 = (var_attrvalue59.equals(true));
                                                                    if (!var_istrueattr61) {
                                                                        out.write("=\"");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent60));
                                                                        out.write("\"");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                out.write(" alt=\"Button Icon\" class=\"cmp-button__icon arrow-left\"/>\r\n                        <span class=\"cmp-button__text\">");
                                                {
                                                    Object var_63 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "buttonLabel"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_63));
                                                }
                                                out.write("</span>\r\n                        <img");
                                                {
                                                    Object var_attrvalue64 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonIcon");
                                                    {
                                                        Object var_attrcontent65 = renderContext.call("xss", var_attrvalue64, "uri");
                                                        {
                                                            boolean var_shoulddisplayattr67 = (((null != var_attrcontent65) && (!"".equals(var_attrcontent65))) && ((!"".equals(var_attrvalue64)) && (!((Object)false).equals(var_attrvalue64))));
                                                            if (var_shoulddisplayattr67) {
                                                                out.write(" src");
                                                                {
                                                                    boolean var_istrueattr66 = (var_attrvalue64.equals(true));
                                                                    if (!var_istrueattr66) {
                                                                        out.write("=\"");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent65));
                                                                        out.write("\"");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                out.write(" alt=\"Button Icon\" class=\"cmp-button__icon arrow-right\"/>\r\n                    </a>\r\n                </div>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        ");
                                            }
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
out.write("\r\n      </div>\r\n    </div>\r\n  </div>\r\n  \r\n  <div class=\"row solution-row d-flex d-lg-none\">\r\n    ");
{
    Object var_collectionvar68 = renderContext.getObjectModel().resolveProperty(_global_solution, "challengeList");
    {
        long var_size69 = ((var_collectionvar68_list_coerced$ == null ? (var_collectionvar68_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar68)) : var_collectionvar68_list_coerced$).size());
        {
            boolean var_notempty70 = (var_size69 > 0);
            if (var_notempty70) {
                {
                    long var_end73 = var_size69;
                    {
                        boolean var_validstartstepend74 = (((0 < var_size69) && true) && (var_end73 > 0));
                        if (var_validstartstepend74) {
                            out.write("<div class=\"accordion p-0 solutions-accordion\" id=\"accordionExample\">");
                            if (var_collectionvar68_list_coerced$ == null) {
                                var_collectionvar68_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar68);
                            }
                            long var_index75 = 0;
                            for (Object item : var_collectionvar68_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index75, 1)).longValue());
                                    {
                                        boolean itemlist_field$_first = (var_index75 == 0);
                                        {
                                            boolean var_traversal77 = (((var_index75 >= 0) && (var_index75 <= var_end73)) && true);
                                            if (var_traversal77) {
                                                out.write("\r\n      <div class=\"accordion-item solutions-accordion-items\">\r\n        <h2 class=\"accordion-header solutions-accordion-header\"");
                                                {
                                                    String var_attrcontent78 = ("heading" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                    out.write(" id=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent78));
                                                    out.write("\"");
                                                }
                                                out.write(">\r\n          <button class=\"accordion-button shadow-none\" type=\"button\" data-bs-toggle=\"collapse\"");
                                                {
                                                    String var_attrcontent79 = ("#collapse" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                    out.write(" data-bs-target=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent79));
                                                    out.write("\"");
                                                }
                                                out.write(" aria-expanded=\"true\"");
                                                {
                                                    String var_attrcontent80 = ("collapse" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                    out.write(" aria-controls=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent80));
                                                    out.write("\"");
                                                }
                                                out.write(">\r\n            <div class=\"challenges-card-accordion\" id=\"challenge-card-id\">\r\n              <div class=\"challenge-head text-uppercase pt-3 pb-4 px-1\">");
                                                {
                                                    Object var_81 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "heading"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_81));
                                                }
                                                out.write("</div>\r\n              <div class=\"challenge-text pb-1 px-1\">");
                                                {
                                                    Object var_82 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_82));
                                                }
                                                out.write("</div>\r\n            </div>\r\n          </button>\r\n        </h2>\r\n        <div");
                                                {
                                                    String var_attrcontent83 = ("collapse" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                    out.write(" id=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent83));
                                                    out.write("\"");
                                                }
                                                {
                                                    String var_attrcontent84 = ("accordion-collapse collapse " + renderContext.getObjectModel().toString(renderContext.call("xss", (itemlist_field$_first ? "show" : ""), "attribute")));
                                                    out.write(" class=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent84));
                                                    out.write("\"");
                                                }
                                                {
                                                    String var_attrcontent85 = ("heading" + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "attribute")));
                                                    out.write(" aria-labelledby=\"");
                                                    out.write(renderContext.getObjectModel().toString(var_attrcontent85));
                                                    out.write("\"");
                                                }
                                                out.write(" data-bs-parent=\"#accordionExample\">\r\n          <div class=\"accordion-body solutions-accordion-body\">\r\n            <div class=\"cmp-card-cont-accordion px-1\">\r\n              <div class=\"cmp-card-wrapper\">\r\n                <div class=\"cmp-card-inner\">\r\n                  <h4>");
                                                {
                                                    Object var_86 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "subHeading"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_86));
                                                }
                                                out.write("</h4>\r\n                  <p>");
                                                {
                                                    Object var_87 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "description"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_87));
                                                }
                                                out.write("</p>\r\n                  <div class=\"cmp-box-button\">\r\n                    <a class=\"text-decoration-none d-inline-flex\"");
                                                {
                                                    String var_attrvalue88 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(item, "newTab")) ? "_blank" : "_self");
                                                    {
                                                        Object var_attrcontent89 = renderContext.call("xss", var_attrvalue88, "attribute");
                                                        {
                                                            boolean var_shoulddisplayattr91 = (((null != var_attrcontent89) && (!"".equals(var_attrcontent89))) && ((!"".equals(var_attrvalue88)) && (!((Object)false).equals(var_attrvalue88))));
                                                            if (var_shoulddisplayattr91) {
                                                                out.write(" target");
                                                                {
                                                                    boolean var_istrueattr90 = (var_attrvalue88.equals(true));
                                                                    if (!var_istrueattr90) {
                                                                        out.write("=\"");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent89));
                                                                        out.write("\"");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                {
                                                    Object var_attrvalue92 = renderContext.call("uriManipulation", renderContext.getObjectModel().resolveProperty(item, "buttonUrl"), obj().with("extension", "html"));
                                                    {
                                                        Object var_attrcontent93 = renderContext.call("xss", var_attrvalue92, "uri");
                                                        {
                                                            boolean var_shoulddisplayattr95 = (((null != var_attrcontent93) && (!"".equals(var_attrcontent93))) && ((!"".equals(var_attrvalue92)) && (!((Object)false).equals(var_attrvalue92))));
                                                            if (var_shoulddisplayattr95) {
                                                                out.write(" href");
                                                                {
                                                                    boolean var_istrueattr94 = (var_attrvalue92.equals(true));
                                                                    if (!var_istrueattr94) {
                                                                        out.write("=\"");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent93));
                                                                        out.write("\"");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                out.write(">\r\n                      <span>");
                                                {
                                                    Object var_96 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "buttonLabel"), "text");
                                                    out.write(renderContext.getObjectModel().toString(var_96));
                                                }
                                                out.write("</span>\r\n                      <span>\r\n                        <img");
                                                {
                                                    Object var_attrvalue97 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "buttonIcon");
                                                    {
                                                        Object var_attrcontent98 = renderContext.call("xss", var_attrvalue97, "uri");
                                                        {
                                                            boolean var_shoulddisplayattr100 = (((null != var_attrcontent98) && (!"".equals(var_attrcontent98))) && ((!"".equals(var_attrvalue97)) && (!((Object)false).equals(var_attrvalue97))));
                                                            if (var_shoulddisplayattr100) {
                                                                out.write(" src");
                                                                {
                                                                    boolean var_istrueattr99 = (var_attrvalue97.equals(true));
                                                                    if (!var_istrueattr99) {
                                                                        out.write("=\"");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent98));
                                                                        out.write("\"");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                {
                                                    Object var_attrvalue101 = renderContext.call("i18n", "Arrow", obj().with("i18n", null));
                                                    {
                                                        Object var_attrcontent102 = renderContext.call("xss", var_attrvalue101, "attribute");
                                                        {
                                                            boolean var_shoulddisplayattr104 = (((null != var_attrcontent102) && (!"".equals(var_attrcontent102))) && ((!"".equals(var_attrvalue101)) && (!((Object)false).equals(var_attrvalue101))));
                                                            if (var_shoulddisplayattr104) {
                                                                out.write(" alt");
                                                                {
                                                                    boolean var_istrueattr103 = (var_attrvalue101.equals(true));
                                                                    if (!var_istrueattr103) {
                                                                        out.write("=\"");
                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent102));
                                                                        out.write("\"");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                out.write("/>\r\n                      </span>\r\n                    </a>\r\n                  </div>\r\n                </div>\r\n              </div>\r\n            </div>\r\n          </div>\r\n        </div>\r\n      </div>\r\n    ");
                                            }
                                        }
                                    }
                                }
                                var_index75++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar68_list_coerced$ = null;
}
out.write("\r\n  </div>\r\n</div>\r\n");
{
    Object var_templatevar105 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions106_field$_isempty = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_solution, "challengeList")));
        {
            java.util.Map var_templateoptions106 = obj().with("isEmpty", var_templateoptions106_field$_isempty);
            callUnit(out, renderContext, var_templatevar105, var_templateoptions106);
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

