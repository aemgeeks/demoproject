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

public final class page__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_page = null;
Object _global_pwa = null;
Object _global_environment = null;
Object _global_tagdata = null;
Object _global_head = null;
Object _global_footer = null;
Object _global_redirect = null;
Object _dynamic_currentpage = bindings.get("currentpage");
Object _global_datalayerenabled = null;
Object _dynamic_wcmmode = bindings.get("wcmmode");
Object _global_isredirectpage = null;
out.write("\r\n<!DOCTYPE HTML>\r\n");
_global_page = renderContext.call("use", com.adobe.cq.wcm.core.components.models.Page.class.getName(), obj());
_global_pwa = renderContext.call("use", com.adobe.cq.wcm.core.components.models.PWA.class.getName(), obj());
_global_environment = renderContext.call("use", com.myproject.aem.core.models.EnvironmentModel.class.getName(), obj());
_global_tagdata = renderContext.call("use", com.myproject.aem.core.models.AnalyticsTrackingProperties.class.getName(), obj());
_global_head = renderContext.call("use", "head.html", obj());
_global_footer = renderContext.call("use", "footer.html", obj());
_global_redirect = renderContext.call("use", "redirect.html", obj());
out.write("<html");
{
    Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_global_page, "language");
    {
        Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
        {
            boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
            if (var_shoulddisplayattr3) {
                out.write(" lang");
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
out.write(">\r\n\r\n<head>");
{
    Object var_templatevar4 = renderContext.getObjectModel().resolveProperty(_global_head, "head");
    {
        Object var_templateoptions5_field$_environment = _global_environment;
        {
            Object var_templateoptions5_field$_page = _global_page;
            {
                Object var_templateoptions5_field$_pwa = _global_pwa;
                {
                    java.util.Map var_templateoptions5 = obj().with("environment", var_templateoptions5_field$_environment).with("page", var_templateoptions5_field$_page).with("pwa", var_templateoptions5_field$_pwa);
                    callUnit(out, renderContext, var_templatevar4, var_templateoptions5);
                }
            }
        }
    }
}
out.write("</head>\r\n\r\n<body");
{
    Object var_attrvalue6 = renderContext.getObjectModel().resolveProperty(_global_page, "cssClassNames");
    {
        Object var_attrcontent7 = renderContext.call("xss", var_attrvalue6, "attribute");
        {
            boolean var_shoulddisplayattr9 = (((null != var_attrcontent7) && (!"".equals(var_attrcontent7))) && ((!"".equals(var_attrvalue6)) && (!((Object)false).equals(var_attrvalue6))));
            if (var_shoulddisplayattr9) {
                out.write(" class");
                {
                    boolean var_istrueattr8 = (var_attrvalue6.equals(true));
                    if (!var_istrueattr8) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent7));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue10 = renderContext.getObjectModel().resolveProperty(_global_page, "id");
    {
        Object var_attrcontent11 = renderContext.call("xss", var_attrvalue10, "attribute");
        {
            boolean var_shoulddisplayattr13 = (((null != var_attrcontent11) && (!"".equals(var_attrcontent11))) && ((!"".equals(var_attrvalue10)) && (!((Object)false).equals(var_attrvalue10))));
            if (var_shoulddisplayattr13) {
                out.write(" id");
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
{
    boolean var_attrvalue14 = (renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_page, "data")) ? true : false);
    {
        Object var_attrcontent15 = renderContext.call("xss", var_attrvalue14, "attribute");
        {
            boolean var_shoulddisplayattr17 = (((null != var_attrcontent15) && (!"".equals(var_attrcontent15))) && ((!"".equals(var_attrvalue14)) && (false != var_attrvalue14)));
            if (var_shoulddisplayattr17) {
                out.write(" data-cmp-data-layer-enabled");
                {
                    boolean var_istrueattr16 = (var_attrvalue14 == true);
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
out.write(">\r\n\r\n  <div id=\"analyticsData\" class=\"\"");
{
    Object var_attrvalue18 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getCurrentPagePath");
    {
        Object var_attrcontent19 = renderContext.call("xss", var_attrvalue18, "attribute");
        {
            boolean var_shoulddisplayattr21 = (((null != var_attrcontent19) && (!"".equals(var_attrcontent19))) && ((!"".equals(var_attrvalue18)) && (!((Object)false).equals(var_attrvalue18))));
            if (var_shoulddisplayattr21) {
                out.write(" data-getcurrentpagepath");
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
{
    Object var_attrvalue22 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getBreacrumbs");
    {
        Object var_attrcontent23 = renderContext.call("xss", var_attrvalue22, "attribute");
        {
            boolean var_shoulddisplayattr25 = (((null != var_attrcontent23) && (!"".equals(var_attrcontent23))) && ((!"".equals(var_attrvalue22)) && (!((Object)false).equals(var_attrvalue22))));
            if (var_shoulddisplayattr25) {
                out.write(" data-getbreacrumbs");
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
{
    Object var_attrvalue26 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getEnv");
    {
        Object var_attrcontent27 = renderContext.call("xss", var_attrvalue26, "attribute");
        {
            boolean var_shoulddisplayattr29 = (((null != var_attrcontent27) && (!"".equals(var_attrcontent27))) && ((!"".equals(var_attrvalue26)) && (!((Object)false).equals(var_attrvalue26))));
            if (var_shoulddisplayattr29) {
                out.write(" data-getenv");
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
{
    Object var_attrvalue30 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getPageCategory");
    {
        Object var_attrcontent31 = renderContext.call("xss", var_attrvalue30, "attribute");
        {
            boolean var_shoulddisplayattr33 = (((null != var_attrcontent31) && (!"".equals(var_attrcontent31))) && ((!"".equals(var_attrvalue30)) && (!((Object)false).equals(var_attrvalue30))));
            if (var_shoulddisplayattr33) {
                out.write(" data-getpagecategory");
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
{
    Object var_attrvalue34 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getContentHierarchy");
    {
        Object var_attrcontent35 = renderContext.call("xss", var_attrvalue34, "attribute");
        {
            boolean var_shoulddisplayattr37 = (((null != var_attrcontent35) && (!"".equals(var_attrcontent35))) && ((!"".equals(var_attrvalue34)) && (!((Object)false).equals(var_attrvalue34))));
            if (var_shoulddisplayattr37) {
                out.write(" data-getcontenthierarchy");
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
{
    Object var_attrvalue38 = renderContext.getObjectModel().resolveProperty(_dynamic_currentpage, "title");
    {
        Object var_attrcontent39 = renderContext.call("xss", var_attrvalue38, "attribute");
        {
            boolean var_shoulddisplayattr41 = (((null != var_attrcontent39) && (!"".equals(var_attrcontent39))) && ((!"".equals(var_attrvalue38)) && (!((Object)false).equals(var_attrvalue38))));
            if (var_shoulddisplayattr41) {
                out.write(" data-title");
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
{
    Object var_attrvalue42 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getPageType");
    {
        Object var_attrcontent43 = renderContext.call("xss", var_attrvalue42, "attribute");
        {
            boolean var_shoulddisplayattr45 = (((null != var_attrcontent43) && (!"".equals(var_attrcontent43))) && ((!"".equals(var_attrvalue42)) && (!((Object)false).equals(var_attrvalue42))));
            if (var_shoulddisplayattr45) {
                out.write(" data-getpagetype");
                {
                    boolean var_istrueattr44 = (var_attrvalue42.equals(true));
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
{
    Object var_attrvalue46 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getSiteCountry");
    {
        Object var_attrcontent47 = renderContext.call("xss", var_attrvalue46, "attribute");
        {
            boolean var_shoulddisplayattr49 = (((null != var_attrcontent47) && (!"".equals(var_attrcontent47))) && ((!"".equals(var_attrvalue46)) && (!((Object)false).equals(var_attrvalue46))));
            if (var_shoulddisplayattr49) {
                out.write(" data-getsitecountry");
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
    Object var_attrvalue50 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getSiteLanguage");
    {
        Object var_attrcontent51 = renderContext.call("xss", var_attrvalue50, "attribute");
        {
            boolean var_shoulddisplayattr53 = (((null != var_attrcontent51) && (!"".equals(var_attrcontent51))) && ((!"".equals(var_attrvalue50)) && (!((Object)false).equals(var_attrvalue50))));
            if (var_shoulddisplayattr53) {
                out.write(" data-getsiteLanguage");
                {
                    boolean var_istrueattr52 = (var_attrvalue50.equals(true));
                    if (!var_istrueattr52) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent51));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue54 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getPrevPage");
    {
        Object var_attrcontent55 = renderContext.call("xss", var_attrvalue54, "attribute");
        {
            boolean var_shoulddisplayattr57 = (((null != var_attrcontent55) && (!"".equals(var_attrcontent55))) && ((!"".equals(var_attrvalue54)) && (!((Object)false).equals(var_attrvalue54))));
            if (var_shoulddisplayattr57) {
                out.write(" data-getprevpage");
                {
                    boolean var_istrueattr56 = (var_attrvalue54.equals(true));
                    if (!var_istrueattr56) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent55));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue58 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getDeviceOS");
    {
        Object var_attrcontent59 = renderContext.call("xss", var_attrvalue58, "attribute");
        {
            boolean var_shoulddisplayattr61 = (((null != var_attrcontent59) && (!"".equals(var_attrcontent59))) && ((!"".equals(var_attrvalue58)) && (!((Object)false).equals(var_attrvalue58))));
            if (var_shoulddisplayattr61) {
                out.write(" data-getdeviceos");
                {
                    boolean var_istrueattr60 = (var_attrvalue58.equals(true));
                    if (!var_istrueattr60) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent59));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue62 = renderContext.getObjectModel().resolveProperty(_global_tagdata, "getDomainName");
    {
        Object var_attrcontent63 = renderContext.call("xss", var_attrvalue62, "attribute");
        {
            boolean var_shoulddisplayattr65 = (((null != var_attrcontent63) && (!"".equals(var_attrcontent63))) && ((!"".equals(var_attrvalue62)) && (!((Object)false).equals(var_attrvalue62))));
            if (var_shoulddisplayattr65) {
                out.write(" data-getdomainName");
                {
                    boolean var_istrueattr64 = (var_attrvalue62.equals(true));
                    if (!var_istrueattr64) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent63));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue66 = renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_page, "data"), "json");
    {
        Object var_attrcontent67 = renderContext.call("xss", var_attrvalue66, "attribute");
        {
            boolean var_shoulddisplayattr69 = (((null != var_attrcontent67) && (!"".equals(var_attrcontent67))) && ((!"".equals(var_attrvalue66)) && (!((Object)false).equals(var_attrvalue66))));
            if (var_shoulddisplayattr69) {
                out.write(" data-json");
                {
                    boolean var_istrueattr68 = (var_attrvalue66.equals(true));
                    if (!var_istrueattr68) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent67));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
{
    Object var_attrvalue70 = renderContext.getObjectModel().resolveProperty(_global_page, "id");
    {
        Object var_attrcontent71 = renderContext.call("xss", var_attrvalue70, "attribute");
        {
            boolean var_shoulddisplayattr73 = (((null != var_attrcontent71) && (!"".equals(var_attrcontent71))) && ((!"".equals(var_attrvalue70)) && (!((Object)false).equals(var_attrvalue70))));
            if (var_shoulddisplayattr73) {
                out.write(" data-id");
                {
                    boolean var_istrueattr72 = (var_attrvalue70.equals(true));
                    if (!var_istrueattr72) {
                        out.write("=\"");
                        out.write(renderContext.getObjectModel().toString(var_attrcontent71));
                        out.write("\"");
                    }
                }
            }
        }
    }
}
out.write(">\r\n  </div>\r\n  ");
{
    Object var_includedresult74 = renderContext.call("include", "dramix-gtm.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult74));
}
out.write("\r\n\r\n  ");
_global_datalayerenabled = renderContext.getObjectModel().resolveProperty(_global_page, "data");
if (renderContext.getObjectModel().toBoolean(_global_datalayerenabled)) {
    out.write("<script>");
    {
        String var_76 = (((("\r\n    window.adobeDataLayer = window.adobeDataLayer || [];\r\n    adobeDataLayer.push({\r\n      page: JSON.parse(\"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_global_page, "data"), "json"), "scriptString"))) + "\"),\r\n      event: 'cmp:show',\r\n      eventInfo: {\r\n        path: 'page.") + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_page, "id"), "scriptString"))) + "'\r\n      }\r\n    });\r\n  ");
        out.write(renderContext.getObjectModel().toString(var_76));
    }
    out.write("</script>");
}
out.write("\r\n  ");
_global_isredirectpage = ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_global_page, "redirectTarget")) ? ((renderContext.getObjectModel().toBoolean(renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit")) ? renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "edit") : renderContext.getObjectModel().resolveProperty(_dynamic_wcmmode, "preview"))) : renderContext.getObjectModel().resolveProperty(_global_page, "redirectTarget")));
if (renderContext.getObjectModel().toBoolean(_global_isredirectpage)) {
    {
        Object var_templatevar77 = renderContext.getObjectModel().resolveProperty(_global_redirect, "redirect");
        {
            Object var_templateoptions78_field$_redirecttarget = renderContext.getObjectModel().resolveProperty(_global_page, "redirectTarget");
            {
                java.util.Map var_templateoptions78 = obj().with("redirectTarget", var_templateoptions78_field$_redirecttarget);
                callUnit(out, renderContext, var_templatevar77, var_templateoptions78);
            }
        }
    }
}
out.write("\r\n  ");
{
    boolean var_testvariable79 = (!renderContext.getObjectModel().toBoolean(_global_isredirectpage));
    if (var_testvariable79) {
        out.write("\r\n    ");
        {
            Object var_includedresult80 = renderContext.call("include", "body.skiptomaincontent.html", obj());
            out.write(renderContext.getObjectModel().toString(var_includedresult80));
        }
        out.write("\r\n    ");
        {
            Object var_includedresult82 = renderContext.call("include", "body.socialmedia_begin.html", obj());
            out.write(renderContext.getObjectModel().toString(var_includedresult82));
        }
        out.write("\r\n    ");
        {
            Object var_includedresult84 = renderContext.call("include", "body.html", obj());
            out.write(renderContext.getObjectModel().toString(var_includedresult84));
        }
        out.write("\r\n    ");
        {
            Object var_templatevar86 = renderContext.getObjectModel().resolveProperty(_global_footer, "footer");
            {
                Object var_templateoptions87_field$_page = _global_page;
                {
                    Object var_templateoptions87_field$_pwa = _global_pwa;
                    {
                        java.util.Map var_templateoptions87 = obj().with("page", var_templateoptions87_field$_page).with("pwa", var_templateoptions87_field$_pwa);
                        callUnit(out, renderContext, var_templatevar86, var_templateoptions87);
                    }
                }
            }
        }
        out.write("\r\n    ");
        {
            Object var_includedresult88 = renderContext.call("include", "body.socialmedia_end.html", obj());
            out.write(renderContext.getObjectModel().toString(var_includedresult88));
        }
        out.write("\r\n  ");
    }
}
out.write("\r\n</body>\r\n\r\n</html>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

