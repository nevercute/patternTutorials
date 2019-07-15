//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ataccama.dqc.tasks.iway.adapters.support;

import com.ataccama.dqc.commons.util.AssertUtil;
import com.ataccama.dqc.commons.util.reflect.BeanUtil;
import com.ataccama.dqc.commons.util.xml.IndentingXmlWriter;
import com.ataccama.dqc.commons.util.xml.XmlDomUtil;
import com.ataccama.dqc.commons.util.xml.XmlPrinter;
import com.ataccama.dqc.model.environment.adapter.IAdapterSupport;
import com.ataccama.dqc.processor.bin.config.IAdapterSupportFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.w3c.dom.Element;

public class AdapterSupportFactory implements IAdapterSupportFactory {
    private AdapterNameBean[] adapterSources;

    private Logger logger = Logger.getLogger(AdapterSupportFactory.class);

    public AdapterSupportFactory() {
    }

    public AdapterNameBean[] getAdapterSources() {
        return this.adapterSources;
    }

    public void setAdapterSources(AdapterNameBean[] adapterSources) {
        this.adapterSources = adapterSources;
    }

    public IAdapterSupport createSupport() {
        return this.createAdapterSupport(this.adapterSources);
    }

    private IAdapterSupport createAdapterSupport(AdapterNameBean[] adapterSources) {
        try {
            DefaultAdapterSupport adapterSupport = new DefaultAdapterSupport();

            for(int i = 0; i < adapterSources.length; ++i) {
                AdapterNameBean b = adapterSources[i];
                logger.info("AdapterSupportFactory.createAdapterSupport; b.getServicesDescriptionFile() = "+ b.getServicesDescriptionFile() + "; i =  "+i);
                File servicesDescriptionFile = new File(b.getServicesDescriptionFile());
                if (!servicesDescriptionFile.exists()) {
                    throw new IllegalStateException("");
                }

                Map parameters = new HashMap();

                for(int j = 0; j < b.getParameters().length; ++j) {
                    logger.info("AdapterSupportFactory.createAdapterSupport; parameters.put: b.getParameters()[j].getName() "+b.getParameters()[j].getName()
                            + ";b.getParameters()[j].getName() = "+b.getParameters()[j].getName()+"; i =  "+i);
                    parameters.put(b.getParameters()[j].getName(), b.getParameters()[j].getName());
                }

                File adapterDescriptionFile = new File(b.getAdapterDescriptionFile());
                logger.info("AdapterSupportFactory.createAdapterSupport; adapterDescriptionFile = "+ adapterDescriptionFile.getAbsolutePath() + ";" +
                        "adapterDescriptionFile.exists() = "+ adapterDescriptionFile.exists() +"; i =  "+i);
                if (!adapterDescriptionFile.exists()) {
                    throw new IllegalStateException("");
                }

                Map adapterConfiguration = this.createAdapterConfiguration(adapterDescriptionFile);
                AdapterServicesDescriptionBean servicesBean = new AdapterServicesDescriptionBean();
                BeanUtil.setUpBean(servicesBean, new FileInputStream(servicesDescriptionFile));
                AdapterServiceConfig[] servicesConfigs = this.createServicesConfigs(servicesBean);
                adapterSupport.createAdapterSource(b.getName(), parameters, servicesConfigs, Class.forName(servicesBean.getAdapterClassName()), adapterConfiguration);
            }

            return adapterSupport;
        } catch (Exception var11) {
            throw new RuntimeException("Error when processing the adapter sources configuration.", var11);
        }
    }

    private Map createAdapterConfiguration(File adapterDescriptionFile) throws Exception {
        Map adapterConfiguration = new HashMap();
        Element d = XmlDomUtil.createRootElementFromStream(new FileInputStream(adapterDescriptionFile));
        Element[] nodes = XmlDomUtil.getChildElementsByTagName(d, "node");

        for(int i = 0; i < nodes.length; ++i) {
            String name = XmlDomUtil.getAttributeValue(nodes[i], "name");
            Element[] children = XmlDomUtil.getChildElements(nodes[i]);
            AssertUtil.assertEquals(children.length, 1, "Expected just one child.");
            Element nodeContentEl = children[0];
            StringWriter w = new StringWriter();
            IndentingXmlWriter ind = new IndentingXmlWriter(w, "UTF-8", "\t");
            XmlPrinter.printXml(nodeContentEl, ind);
            ind.close();
            adapterConfiguration.put(name, w.toString());
        }

        return adapterConfiguration;
    }

    private AdapterServiceConfig[] createServicesConfigs(AdapterServicesDescriptionBean servicesBean) throws IOException {
        AdapterServiceBean[] servicesBeans = servicesBean.getServices();
        AdapterServiceConfig[] servicesConfigs = new AdapterServiceConfig[servicesBeans.length];

        for(int i = 0; i < servicesBeans.length; ++i) {
            AdapterServiceBean serviceBean = servicesBeans[i];
            servicesConfigs[i] = new AdapterServiceConfig(serviceBean.getName(), serviceBean.getResponseMapping(), serviceBean.getRequestMapping());
        }

        return servicesConfigs;
    }
}
