/*
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
 */
package model.workspace.copycomposer.managers;

import fede.workspace.eclipse.content.SubFileContentManager;
import model.workspace.copycomposer.CopyComposerCST;
import fr.imag.adele.cadse.cadseg.managers.build.exporter.ExporterManager;
import fr.imag.adele.cadse.core.CadseException;
import java.util.UUID;
import fr.imag.adele.cadse.core.content.ContentItem;
import fr.imag.adele.cadse.core.var.ContextVariable;
import fr.imag.adele.cadse.core.var.Variable;
import fr.imag.adele.cadse.core.GenStringBuilder;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;

/**
 * @generated
 */
public class JavaRefExporterManager extends ExporterManager {

	

	/**
	 * @generated
	 */
	public JavaRefExporterManager() {
		super();
	}

	/**
	 * @generated
	 */
	@Override
	public String computeQualifiedName(final Item item, final String name, final Item parent, final LinkType lt) {
		StringBuilder sb = new StringBuilder();
		try {
			Object value;
			Item currentItem;
			if (parent != null) {
				sb.append(parent.getQualifiedName());
			}
			if (sb.length() != 0) {
				sb.append(".");
			}
			sb.append(name);
			return sb.toString();
		} catch (Throwable e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * @generated
	 */
	@Override
	public String getDisplayName(final Item item) {
		try {
			Object value;
			if (item != null) {
				return item.getName();
			}
			return "";
		} catch (Throwable e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * Validate there is only one JavaRefExporter associated with a component.
	 * 
	 * @see fr.imag.adele.cadse.core.DefaultItemManager#canCreateMeItem(fr.imag.adele.cadse.core.Item, fr.imag.adele.cadse.core.LinkType, fr.imag.adele.cadse.core.ItemType)
	 */
	@Override
	public String canCreateMeItem(Item itemParent, LinkType lt,ItemType destType) {
		for (Item existingComposer : itemParent.getOutgoingItems(lt,true)) {
			if (existingComposer.isInstanceOf(CopyComposerCST.JAVA_REF_EXPORTER))
				return "Java content exporter already added";
		}
		
		return null;
	}
	
	/**
		get a link 'contents' from 'JavaRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Link getContentsLink(Item javaRefExporter) {
		return javaRefExporter.getOutgoingLink(CopyComposerCST.JAVA_REF_EXPORTER_lt_CONTENTS);
	}

	/**
		get all link destination 'contents' from 'JavaRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Item getContentsAll(Item javaRefExporter) {
		return javaRefExporter.getOutgoingItem(CopyComposerCST.JAVA_REF_EXPORTER_lt_CONTENTS, false);
	}

	/**
		get resolved link destination 'contents' from 'JavaRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Item getContents(Item javaRefExporter) {
		return javaRefExporter.getOutgoingItem(CopyComposerCST.JAVA_REF_EXPORTER_lt_CONTENTS, true);
	}

	/**
		set a link 'contents' from 'JavaRefExporter' to 'ContentItem'.
		@generated
	*/
	static public void setContents(Item javaRefExporter, Item value) throws CadseException {
		javaRefExporter.setOutgoingItem(CopyComposerCST.JAVA_REF_EXPORTER_lt_CONTENTS,value);
	}

	@SuppressWarnings("hiding")
	public static final String	DEFAUL_CLASS_NAME	= "fede.workspace.eclipse.composition.copy.exporter.JavaClassRefExporter";

	@Override
	public String getDefaultClassName() {
		return DEFAUL_CLASS_NAME;
	}

	@Override
	public boolean mustBeExtended() {
		return false;
	}
}
