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

public final class customheaderlibs__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_clientlib = null;
out.write("\r\n");
{
    Object var_includedresult0 = renderContext.call("include", "ogtags.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult0));
}
out.write("\r\n");
{
    Object var_includedresult2 = renderContext.call("include", "schema.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult2));
}
out.write("\r\n");
{
    Object var_includedresult4 = renderContext.call("include", "onetrust.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult4));
}
out.write("\r\n");
{
    Object var_includedresult6 = renderContext.call("include", "gtm-header.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult6));
}
out.write("\r\n\r\n");
_global_clientlib = renderContext.call("use", "/libs/granite/sightly/templates/clientlib.html", obj());
out.write("\r\n    ");
{
    Object var_templatevar8 = renderContext.getObjectModel().resolveProperty(_global_clientlib, "css");
    {
        String var_templateoptions9_field$_categories = "myproject.base";
        {
            java.util.Map var_templateoptions9 = obj().with("categories", var_templateoptions9_field$_categories);
            callUnit(out, renderContext, var_templatevar8, var_templateoptions9);
        }
    }
}
out.write("\r\n\r\n<link href=\"/etc.clientlibs/myproject/clientlibs/clientlib-site/resources/images/favicons/favicon.png\" rel=\"icon\" type=\"image/x-icon\"/>\r\n\r\n\r\n<!-- lottie animation load starts -->\r\n\r\n<script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>\r\n\r\n<!-- lottie animation load Ends -->\r\n<!-- google captcha script -->\r\n\r\n<script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

