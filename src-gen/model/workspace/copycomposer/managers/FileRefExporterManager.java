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

import model.workspace.copycomposer.CopyComposerCST;
import fr.imag.adele.cadse.cadseg.managers.build.exporter.ExporterManager;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;

/**
 * @generated
 */
public class FileRefExporterManager extends ExporterManager {

	/**
	 * @generated
	 */
	public FileRefExporterManager() {
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
	 * @generated
	 */
	public static final String getExportedFolderAttribute(final Item fileRefExporter) {
		return fileRefExporter.getAttributeWithDefaultValue(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_, null);
	}

	/**
	 * @generated
	 */
	public static final void setExportedFolderAttribute(final Item fileRefExporter, final String value) {
		try {
			fileRefExporter.setAttribute(CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER_, value);
		} catch (Throwable t) {

		}
	}

	/**
		get a link 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Link getContentsLink(Item fileRefExporter) {
		return fileRefExporter.getOutgoingLink(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS);
	}

	/**
		get all link destination 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Item getContentsAll(Item fileRefExporter) {
		return fileRefExporter.getOutgoingItem(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS, false);
	}

	/**
		get resolved link destination 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public Item getContents(Item fileRefExporter) {
		return fileRefExporter.getOutgoingItem(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS, true);
	}

	/**
		set a link 'contents' from 'FileRefExporter' to 'ContentItem'.
		@generated
	*/
	static public void setContents(Item fileRefExporter, Item value) throws CadseException {
		fileRefExporter.setOutgoingItem(CopyComposerCST.FILE_REF_EXPORTER_lt_CONTENTS,value);
	}

	
}
