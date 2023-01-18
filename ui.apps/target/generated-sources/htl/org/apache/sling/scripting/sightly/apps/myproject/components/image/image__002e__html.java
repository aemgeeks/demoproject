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
package org.apache.sling.scripting.sightly.apps.myproject.components.image;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class image__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_image = null;
Object _global_component = null;
Object _global_templates = null;
Object _dynamic_wcmmode = bindings.get("wcmmode");
Object _dynamic_resource = bindings.get("resource");
Object _global_usemap = null;
Object _dynamic_model = bindings.get("model");
Collection var_collectionvar76_list_coerced$ = null;
Object _dynamic_properties = bindings.get("properties");
_global_image = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Image.class.getName(), obj());
_global_component = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Component.class.getName(), obj());
_global_templates = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
{
    Object var_testvariable0 = renderContext.getObjectModel().resolveProperty(_global_image, "src");
    if (renderContext.getObjectModel().toBoolean(var_testvariable0)) {
        out.write("<div data-cmp-is=\"image\"");
        {
            Object var_attrvalue1 = renderContext.getObjectModel().resolveProperty(_global_image, "lazyEnabled");
            {
                Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
                {
                    boolean var_shoulddisplayattr4 = (((null != var_attrcontent2) && (!"".equals(var_attrcontent2))) && ((!"".equals(var_attrvalue1)) && (!((Object)false).equals(var_attrvalue1))));
                    if (var_shoulddisplayattr4) {
                        out.write(" data-cmp-lazy");
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
            Object var_attrvalue5 = renderContext.getObjectModel().resolveProperty(_global_image, "lazyThreshold");
            {
                Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
                {
                    boolean var_shoulddisplayattr8 = (((null != var_attrcontent6) && (!"".equals(var_attrcontent6))) && ((!"".equals(var_attrvalue5)) && (!((Object)false).equals(var_attrvalue5))));
                    if (var_shoulddisplayattr8) {
                        out.write(" data-cmp-lazythreshold");
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
            Object var_attrvalue9 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "srcUriTemplate")) ? renderContext.getObjectModel().resolveProperty(_global_image, "srcUriTemplate") : renderContext.getObjectModel().resolveProperty(_global_image, "src"));
            {
                Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
                {
                    boolean var_shoulddisplayattr12 = (((null != var_attrcontent10) && (!"".equals(var_attrcontent10))) && ((!"".equals(var_attrvalue9)) && (!((Object)false).equals(var_attrvalue9))));
                    if (var_shoulddisplayattr12) {
                        out.write(" data-cmp-src");
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
        {
            Object var_attrvalue13 = renderContext.getObjectModel().resolveProperty(_global_image, "widths");
            {
                Object var_attrcontent14 = renderContext.call("xss", var_attrvalue13, "attribute");
                {
                    boolean var_shoulddisplayattr16 = (((null != var_attrcontent14) && (!"".equals(var_attrcontent14))) && ((!"".equals(var_attrvalue13)) && (!((Object)false).equals(var_attrvalue13))));
                    if (var_shoulddisplayattr16) {
                        out.write(" data-cmp-widths");
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
            Object var_attrvalue17 = renderContext.getObjectModel().resolveProperty(_global_image, "dmImage");
            {
                Object var_attrcontent18 = renderContext.call("xss", var_attrvalue17, "attribute");
                {
                    boolean var_shoulddisplayattr20 = (((null != var_attrcontent18) && (!"".equals(var_attrcontent18))) && ((!"".equals(var_attrvalue17)) && (!((Object)false).equals(var_attrvalue17))));
                    if (var_shoulddisplayattr20) {
                        out.write(" data-cmp-dmimage");
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
            Object var_attrvalue21 = renderContext.getObjectModel().resolveProperty(_global_image, "smartCropRendition");
            {
                Object var_attrcontent22 = renderContext.call("xss", var_attrvalue21, "attribute");
                {
                    boolean var_shoulddisplayattr24 = (((null != var_attrcontent22) && (!"".equals(var_attrcontent22))) && ((!"".equals(var_attrvalue21)) && (!((Object)false).equals(var_attrvalue21))));
                    if (var_shoulddisplayattr24) {
                        out.write(" data-cmp-smartcroprendition");
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
            Object var_attrvalue25 = renderContext.getObjectModel().resolveProperty(_global_image, "fileReference");
            {
                Object var_attrcontent26 = renderContext.call("xss", var_attrvalue25, "attribute");
                {
                    boolean var_shoulddisplayattr28 = (((null != var_attrcontent26) && (!"".equals(var_attrcontent26))) && ((!"".equals(var_attrvalue25)) && (!((Object)false).equals(var_attrvalue25))));
                    if (var_shoulddisplayattr28) {
                        out.write(" data-asset");
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
            Object var_attrvalue29 = renderContext.getObjectModel().resolveProperty(_global_image, "uuid");
            {
                Object var_attrcontent30 = renderContext.call("xss", var_attrvalue29, "attribute");
                {
                    boolean var_shoulddisplayattr32 = (((null != var_attrcontent30) && (!"".equals(var_attrcontent30))) && ((!"".equals(var_attrvalue29)) && (!((Object)false).equals(var_attrvalue29))));
                    if (var_shoulddisplayattr32) {
                        out.write(" data-asset-id");
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
        {
            Object var_attrvalue33 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "title")) ? renderContext.getObjectModel().resolveProperty(_global_image, "title") : renderContext.getObjectModel().resolveProperty(_global_image, "alt")));
            {
                Object var_attrcontent34 = renderContext.call("xss", var_attrvalue33, "attribute");
                {
                    boolean var_shoulddisplayattr36 = (((null != var_attrcontent34) && (!"".equals(var_attrcontent34))) && ((!"".equals(var_attrvalue33)) && (!((Object)false).equals(var_attrvalue33))));
                    if (var_shoulddisplayattr36) {
                        out.write(" data-title");
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
            Object var_attrvalue37 = renderContext.getObjectModel().resolveProperty(_global_component, "id");
            {
                Object var_attrcontent38 = renderContext.call("xss", var_attrvalue37, "attribute");
                {
                    boolean var_shoulddisplayattr40 = (((null != var_attrcontent38) && (!"".equals(var_attrcontent38))) && ((!"".equals(var_attrvalue37)) && (!((Object)false).equals(var_attrvalue37))));
                    if (var_shoulddisplayattr40) {
                        out.write(" id");
                        {
                            boolean var_istrueattr39 = (var_attrvalue37.equals(true));
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
        {
            Object var_attrvalue41 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_image, "data"), "json");
            {
                Object var_attrcontent42 = renderContext.call("xss", var_attrvalue41, "attribute");
                {
                    boolean var_shoulddisplayattr44 = (((null != var_attrcontent42) && (!"".equals(var_attrcontent42))) && ((!"".equals(var_attrvalue41)) && (!((Object)false).equals(var_attrvalue41))));
                    if (var_shoulddisplayattr44) {
                        out.write(" data-cmp-data-layer");
                        {
                            boolean var_istrueattr43 = (var_attrvalue41.equals(true));
                            if (!var_istrueattr43) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent42));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        {
            String var_attrcontent45 = ("cmp-image" + renderContext.getObjectModel().toString(renderContext.call("xss", ((!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "disabled"))) ? " cq-dd-image" : ""), "attribute")));
            out.write(" class=\"");
            out.write(renderContext.getObjectModel().toString(var_attrcontent45));
            out.write("\"");
        }
        out.write(" itemscope itemtype=\"http://schema.org/ImageObject\">\r\n    ");
        {
            boolean var_unwrapcondition46 = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "link")));
            if (!var_unwrapcondition46) {
                out.write("<a class=\"cmp-image__link\"");
                {
                    Object var_attrvalue47 = renderContext.getObjectModel().resolveProperty(_global_image, "link");
                    {
                        Object var_attrcontent48 = renderContext.call("xss", var_attrvalue47, "uri");
                        {
                            boolean var_shoulddisplayattr50 = (((null != var_attrcontent48) && (!"".equals(var_attrcontent48))) && ((!"".equals(var_attrvalue47)) && (!((Object)false).equals(var_attrvalue47))));
                            if (var_shoulddisplayattr50) {
                                out.write(" href");
                                {
                                    boolean var_istrueattr49 = (var_attrvalue47.equals(true));
                                    if (!var_istrueattr49) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent48));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                {
                    boolean var_attrvalue51 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "data")) ? true : false);
                    {
                        Object var_attrcontent52 = renderContext.call("xss", var_attrvalue51, "attribute");
                        {
                            boolean var_shoulddisplayattr54 = (((null != var_attrcontent52) && (!"".equals(var_attrcontent52))) && ((!"".equals(var_attrvalue51)) && (false != var_attrvalue51)));
                            if (var_shoulddisplayattr54) {
                                out.write(" data-cmp-clickable");
                                {
                                    boolean var_istrueattr53 = (var_attrvalue51 == true);
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
                out.write(" data-cmp-hook-image=\"link\">");
            }
            out.write("\r\n        ");
            {
                boolean var_unwrapcondition55 = ((!org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_global_image, "smartCropRendition"), "SmartCrop:Auto")) && (((!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "lazyEnabled"))) && (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_image, "widths"), "length"), 1))) && (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "areas")))));
                if (!var_unwrapcondition55) {
                    out.write("<noscript data-cmp-hook-image=\"noscript\">");
                }
                out.write("\r\n            ");
_global_usemap = renderContext.call("format", "{0}{1}", obj().with("format", (new Object[] {"#", renderContext.getObjectModel().resolveProperty(_dynamic_resource, "path")})));
                if (renderContext.getObjectModel().toBoolean(_global_usemap)) {
                }
                out.write("   \r\n        <picture>\r\n            <source media=\"(max-width:768px)\"");
                {
                    Object var_attrvalue56 = renderContext.getObjectModel().resolveProperty(_dynamic_model, "desktopImagePath");
                    {
                        Object var_attrcontent57 = renderContext.call("xss", var_attrvalue56, "attribute");
                        {
                            boolean var_shoulddisplayattr59 = (((null != var_attrcontent57) && (!"".equals(var_attrcontent57))) && ((!"".equals(var_attrvalue56)) && (!((Object)false).equals(var_attrvalue56))));
                            if (var_shoulddisplayattr59) {
                                out.write(" srcset");
                                {
                                    boolean var_istrueattr58 = (var_attrvalue56.equals(true));
                                    if (!var_istrueattr58) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent57));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                out.write("/>\r\n            <img");
                {
                    Object var_attrvalue64 = renderContext.getObjectModel().resolveProperty(_dynamic_model, "desktopImagePath");
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
                out.write(" class=\"cmp-image__image\" itemprop=\"contentUrl\" data-cmp-hook-image=\"image\"");
                {
                    Object var_attrvalue68 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "alt")) ? renderContext.getObjectModel().resolveProperty(_global_image, "alt") : true));
                    {
                        Object var_attrcontent69 = renderContext.call("xss", var_attrvalue68, "attribute");
                        {
                            boolean var_shoulddisplayattr71 = (((null != var_attrcontent69) && (!"".equals(var_attrcontent69))) && ((!"".equals(var_attrvalue68)) && (!((Object)false).equals(var_attrvalue68))));
                            if (var_shoulddisplayattr71) {
                                out.write(" alt");
                                {
                                    boolean var_istrueattr70 = (var_attrvalue68.equals(true));
                                    if (!var_istrueattr70) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent69));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                {
                    Object var_attrvalue72 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "displayPopupTitle")) ? renderContext.getObjectModel().resolveProperty(_global_image, "title") : renderContext.getObjectModel().resolveProperty(_global_image, "displayPopupTitle")));
                    {
                        Object var_attrcontent73 = renderContext.call("xss", var_attrvalue72, "attribute");
                        {
                            boolean var_shoulddisplayattr75 = (((null != var_attrcontent73) && (!"".equals(var_attrcontent73))) && ((!"".equals(var_attrvalue72)) && (!((Object)false).equals(var_attrvalue72))));
                            if (var_shoulddisplayattr75) {
                                out.write(" title");
                                {
                                    boolean var_istrueattr74 = (var_attrvalue72.equals(true));
                                    if (!var_istrueattr74) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent73));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                {
                    Object var_attrvalue_usemap60 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "areas")) ? _global_usemap : "");
                    {
                        Object var_attrvalueescaped_usemap61 = renderContext.call("xss", var_attrvalue_usemap60, "attribute", "usemap");
                        {
                            boolean var_shoulddisplayattr_usemap63 = (((null != var_attrvalueescaped_usemap61) && (!"".equals(var_attrvalueescaped_usemap61))) && ((!"".equals(var_attrvalue_usemap60)) && (!((Object)false).equals(var_attrvalue_usemap60))));
                            if (var_shoulddisplayattr_usemap63) {
                                out.write(" usemap");
                                {
                                    boolean var_istruevalue_usemap62 = (var_attrvalue_usemap60.equals(true));
                                    if (!var_istruevalue_usemap62) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrvalueescaped_usemap61));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                out.write("/>\r\n        </picture>\r\n            ");
                {
                    Object var_testvariable83 = renderContext.getObjectModel().resolveProperty(_global_image, "areas");
                    if (renderContext.getObjectModel().toBoolean(var_testvariable83)) {
                        {
                            Object var_collectionvar76 = renderContext.getObjectModel().resolveProperty(_global_image, "areas");
                            {
                                long var_size77 = ((var_collectionvar76_list_coerced$ == null ? (var_collectionvar76_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar76)) : var_collectionvar76_list_coerced$).size());
                                {
                                    boolean var_notempty78 = (var_size77 > 0);
                                    if (var_notempty78) {
                                        {
                                            long var_end81 = var_size77;
                                            {
                                                boolean var_validstartstepend82 = (((0 < var_size77) && true) && (var_end81 > 0));
                                                if (var_validstartstepend82) {
                                                    out.write("<map");
                                                    {
                                                        Object var_attrvalue84 = renderContext.getObjectModel().resolveProperty(_dynamic_resource, "path");
                                                        {
                                                            Object var_attrcontent85 = renderContext.call("xss", var_attrvalue84, "attribute");
                                                            {
                                                                boolean var_shoulddisplayattr87 = (((null != var_attrcontent85) && (!"".equals(var_attrcontent85))) && ((!"".equals(var_attrvalue84)) && (!((Object)false).equals(var_attrvalue84))));
                                                                if (var_shoulddisplayattr87) {
                                                                    out.write(" name");
                                                                    {
                                                                        boolean var_istrueattr86 = (var_attrvalue84.equals(true));
                                                                        if (!var_istrueattr86) {
                                                                            out.write("=\"");
                                                                            out.write(renderContext.getObjectModel().toString(var_attrcontent85));
                                                                            out.write("\"");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    out.write(" data-cmp-hook-image=\"map\">");
                                                    if (var_collectionvar76_list_coerced$ == null) {
                                                        var_collectionvar76_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar76);
                                                    }
                                                    long var_index88 = 0;
                                                    for (Object area : var_collectionvar76_list_coerced$) {
                                                        {
                                                            boolean var_traversal90 = (((var_index88 >= 0) && (var_index88 <= var_end81)) && true);
                                                            if (var_traversal90) {
                                                                out.write("\r\n                <area");
                                                                {
                                                                    Object var_attrvalue91 = renderContext.getObjectModel().resolveProperty(area, "shape");
                                                                    {
                                                                        Object var_attrcontent92 = renderContext.call("xss", var_attrvalue91, "attribute");
                                                                        {
                                                                            boolean var_shoulddisplayattr94 = (((null != var_attrcontent92) && (!"".equals(var_attrcontent92))) && ((!"".equals(var_attrvalue91)) && (!((Object)false).equals(var_attrvalue91))));
                                                                            if (var_shoulddisplayattr94) {
                                                                                out.write(" shape");
                                                                                {
                                                                                    boolean var_istrueattr93 = (var_attrvalue91.equals(true));
                                                                                    if (!var_istrueattr93) {
                                                                                        out.write("=\"");
                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent92));
                                                                                        out.write("\"");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                {
                                                                    Object var_attrvalue95 = renderContext.getObjectModel().resolveProperty(area, "coordinates");
                                                                    {
                                                                        Object var_attrcontent96 = renderContext.call("xss", var_attrvalue95, "attribute");
                                                                        {
                                                                            boolean var_shoulddisplayattr98 = (((null != var_attrcontent96) && (!"".equals(var_attrcontent96))) && ((!"".equals(var_attrvalue95)) && (!((Object)false).equals(var_attrvalue95))));
                                                                            if (var_shoulddisplayattr98) {
                                                                                out.write(" coords");
                                                                                {
                                                                                    boolean var_istrueattr97 = (var_attrvalue95.equals(true));
                                                                                    if (!var_istrueattr97) {
                                                                                        out.write("=\"");
                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent96));
                                                                                        out.write("\"");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                {
                                                                    Object var_attrvalue99 = renderContext.getObjectModel().resolveProperty(area, "href");
                                                                    {
                                                                        Object var_attrcontent100 = renderContext.call("xss", var_attrvalue99, "uri");
                                                                        {
                                                                            boolean var_shoulddisplayattr102 = (((null != var_attrcontent100) && (!"".equals(var_attrcontent100))) && ((!"".equals(var_attrvalue99)) && (!((Object)false).equals(var_attrvalue99))));
                                                                            if (var_shoulddisplayattr102) {
                                                                                out.write(" href");
                                                                                {
                                                                                    boolean var_istrueattr101 = (var_attrvalue99.equals(true));
                                                                                    if (!var_istrueattr101) {
                                                                                        out.write("=\"");
                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent100));
                                                                                        out.write("\"");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                {
                                                                    Object var_attrvalue103 = renderContext.getObjectModel().resolveProperty(area, "target");
                                                                    {
                                                                        Object var_attrcontent104 = renderContext.call("xss", var_attrvalue103, "attribute");
                                                                        {
                                                                            boolean var_shoulddisplayattr106 = (((null != var_attrcontent104) && (!"".equals(var_attrcontent104))) && ((!"".equals(var_attrvalue103)) && (!((Object)false).equals(var_attrvalue103))));
                                                                            if (var_shoulddisplayattr106) {
                                                                                out.write(" target");
                                                                                {
                                                                                    boolean var_istrueattr105 = (var_attrvalue103.equals(true));
                                                                                    if (!var_istrueattr105) {
                                                                                        out.write("=\"");
                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent104));
                                                                                        out.write("\"");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                {
                                                                    Object var_attrvalue107 = renderContext.getObjectModel().resolveProperty(area, "alt");
                                                                    {
                                                                        Object var_attrcontent108 = renderContext.call("xss", var_attrvalue107, "attribute");
                                                                        {
                                                                            boolean var_shoulddisplayattr110 = (((null != var_attrcontent108) && (!"".equals(var_attrcontent108))) && ((!"".equals(var_attrvalue107)) && (!((Object)false).equals(var_attrvalue107))));
                                                                            if (var_shoulddisplayattr110) {
                                                                                out.write(" alt");
                                                                                {
                                                                                    boolean var_istrueattr109 = (var_attrvalue107.equals(true));
                                                                                    if (!var_istrueattr109) {
                                                                                        out.write("=\"");
                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent108));
                                                                                        out.write("\"");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                out.write(" data-cmp-hook-image=\"area\"");
                                                                {
                                                                    Object var_attrvalue111 = renderContext.getObjectModel().resolveProperty(area, "relativeCoordinates");
                                                                    {
                                                                        Object var_attrcontent112 = renderContext.call("xss", var_attrvalue111, "attribute");
                                                                        {
                                                                            boolean var_shoulddisplayattr114 = (((null != var_attrcontent112) && (!"".equals(var_attrcontent112))) && ((!"".equals(var_attrvalue111)) && (!((Object)false).equals(var_attrvalue111))));
                                                                            if (var_shoulddisplayattr114) {
                                                                                out.write(" data-cmp-relcoords");
                                                                                {
                                                                                    boolean var_istrueattr113 = (var_attrvalue111.equals(true));
                                                                                    if (!var_istrueattr113) {
                                                                                        out.write("=\"");
                                                                                        out.write(renderContext.getObjectModel().toString(var_attrcontent112));
                                                                                        out.write("\"");
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                out.write("/>\r\n            ");
                                                            }
                                                        }
                                                        var_index88++;
                                                    }
                                                    out.write("</map>");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            var_collectionvar76_list_coerced$ = null;
                        }
                    }
                }
                out.write("\r\n        ");
                if (!var_unwrapcondition55) {
                    out.write("</noscript>");
                }
            }
            out.write("\r\n    ");
            if (!var_unwrapcondition46) {
                out.write("</a>");
            }
        }
        out.write("\r\n    ");
        {
            Object var_testvariable115 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "imageIcon");
            if (renderContext.getObjectModel().toBoolean(var_testvariable115)) {
                out.write("<img class=\"calculator-icon\"");
                {
                    Object var_attrvalue116 = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "imageIcon");
                    {
                        Object var_attrcontent117 = renderContext.call("xss", var_attrvalue116, "uri");
                        {
                            boolean var_shoulddisplayattr119 = (((null != var_attrcontent117) && (!"".equals(var_attrcontent117))) && ((!"".equals(var_attrvalue116)) && (!((Object)false).equals(var_attrvalue116))));
                            if (var_shoulddisplayattr119) {
                                out.write(" src");
                                {
                                    boolean var_istrueattr118 = (var_attrvalue116.equals(true));
                                    if (!var_istrueattr118) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent117));
                                        out.write("\"");
                                    }
                                }
                            }
                        }
                    }
                }
                out.write(" alt=\"Icon on image\"/>");
            }
        }
        out.write("\r\n    ");
        {
            Object var_testvariable120 = (((!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "displayPopupTitle"))) ? renderContext.getObjectModel().resolveProperty(_global_image, "title") : (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "displayPopupTitle")))));
            if (renderContext.getObjectModel().toBoolean(var_testvariable120)) {
                out.write("<span class=\"cmp-image__title\" itemprop=\"caption\">");
                {
                    Object var_121 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_image, "title"), "text");
                    out.write(renderContext.getObjectModel().toString(var_121));
                }
                out.write("</span>");
            }
        }
        out.write("\r\n    ");
        {
            Object var_testvariable122 = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "displayPopupTitle")) ? renderContext.getObjectModel().resolveProperty(_global_image, "title") : renderContext.getObjectModel().resolveProperty(_global_image, "displayPopupTitle")));
            if (renderContext.getObjectModel().toBoolean(var_testvariable122)) {
                out.write("<meta itemprop=\"caption\"");
                {
                    Object var_attrvalue123 = renderContext.getObjectModel().resolveProperty(_global_image, "title");
                    {
                        Object var_attrcontent124 = renderContext.call("xss", var_attrvalue123, "attribute");
                        {
                            boolean var_shoulddisplayattr126 = (((null != var_attrcontent124) && (!"".equals(var_attrcontent124))) && ((!"".equals(var_attrvalue123)) && (!((Object)false).equals(var_attrvalue123))));
                            if (var_shoulddisplayattr126) {
                                out.write(" content");
                                {
                                    boolean var_istrueattr125 = (var_attrvalue123.equals(true));
                                    if (!var_istrueattr125) {
                                        out.write("=\"");
                                        out.write(renderContext.getObjectModel().toString(var_attrcontent124));
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
        out.write("\r\n</div>");
    }
}
out.write("\r\n");
{
    Object var_templatevar127 = renderContext.getObjectModel().resolveProperty(_global_templates, "placeholder");
    {
        boolean var_templateoptions128_field$_isempty = (!renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_image, "src")));
        {
            String var_templateoptions128_field$_classappend = "cmp-image cq-dd-image";
            {
                java.util.Map var_templateoptions128 = obj().with("isEmpty", var_templateoptions128_field$_isempty).with("classAppend", var_templateoptions128_field$_classappend);
                callUnit(out, renderContext, var_templatevar127, var_templateoptions128);
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

