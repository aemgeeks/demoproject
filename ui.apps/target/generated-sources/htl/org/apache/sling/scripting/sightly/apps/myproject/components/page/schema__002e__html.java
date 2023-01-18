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

public final class schema__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_extmodel = null;
Object _dynamic_inheritedpageproperties = bindings.get("inheritedpageproperties");
_global_extmodel = renderContext.call("use", com.myproject.aem.core.models.ExternalizerConfigData.class.getName(), obj());
out.write("\r\n");
{
    boolean var_testvariable0 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_inheritedpageproperties, "jcr:language"), "en"));
    if (var_testvariable0) {
        out.write("\r\n\r\n\r\n ");
    }
}
out.write("\r\n\r\n");
{
    boolean var_testvariable1 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_inheritedpageproperties, "jcr:language"), "es"));
    if (var_testvariable1) {
        out.write("\r\n<script type=\"application/ld+json\">");
        {
            String var_2 = (("\r\n{\r\n  \"@context\": \"https://schema.org\",\r\n  \"@type\": \"Organization\",\r\n  \"name\": \"company\u00AE\",\r\n  \"url\": \"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_extmodel, "domainName"), "html"))) + "/url\",\r\n  \"logo\": \"https://www.google.com.logo.jpg\",\r\n  \"sameAs\": [\r\n    \"https://www.facebook.com/company\",\r\n    \"https://twitter.com/company\",\r\n    \"https://www.youtube.com/c/company\",\r\n    \"https://www.linkedin.com/showcase/company\"\r\n  ]\r\n}\r\n");
            out.write(renderContext.getObjectModel().toString(var_2));
        }
        out.write("</script>\r\n\r\n<script type=\"application/ld+json\">");
        {
            String var_3 = ((" \r\n{\r\n  \"@context\": \"http://www.schema.org\",\r\n  \"@type\": \"WebSite\",\r\n  \"name\": \"MyProject\u00AE\",\r\n  \"alternateName\": \"Alt Project\u00AE\",\r\n  \"url\": \"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_extmodel, "domainName"), "html"))) + "/content/\"\r\n}\r\n ");
            out.write(renderContext.getObjectModel().toString(var_3));
        }
        out.write("</script>\r\n \r\n <script type=\"application/ld+json\">");
        {
            String var_4 = (("\r\n{\r\n  \"@context\": \"https://schema.org\",\r\n  \"@type\": \"Organization\",\r\n  \"name\": \"Bekaert Dramix\u00AE\",\r\n  \"url\": \"" + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_extmodel, "domainName"), "html"))) + "/url\",\r\n  \"logo\": \"url\"\r\n}\r\n");
            out.write(renderContext.getObjectModel().toString(var_4));
        }
        out.write("</script>\r\n \r\n");
    }
}


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

