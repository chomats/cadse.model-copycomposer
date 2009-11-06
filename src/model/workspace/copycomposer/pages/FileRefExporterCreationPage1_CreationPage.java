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
package model.workspace.copycomposer.pages;

import model.workspace.copycomposer.CopyComposerCST;
import fede.workspace.model.manager.properties.impl.ic.IC_DefaultForList;
import fede.workspace.model.manager.properties.impl.ui.DListUI;
import fede.workspace.model.manager.properties.impl.ui.DTextUI;
import fr.imag.adele.cadse.cadseg.pages.build.exporter.ExporterCreationPage1_CreationPage;
import fr.imag.adele.cadse.core.CadseGCST;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.impl.ui.mc.MC_AttributesItem;
import fr.imag.adele.cadse.core.impl.ui.mc.MC_DefaultForList;
import fr.imag.adele.cadse.core.ui.EPosLabel;

/**
 * @generated
 */
public class FileRefExporterCreationPage1_CreationPage extends
		ExporterCreationPage1_CreationPage {

	/**
	 * @generated
	 */
	protected DTextUI fieldExportedFolder;

	/**
	 * @generated
	 */
	protected FileRefExporterCreationPage1_CreationPage(final String id,
			final String label, final String title, final String description,
			final boolean isPageComplete, final int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	 * @generated
	 */
	public FileRefExporterCreationPage1_CreationPage(final Item parent,
			final ItemType it, final LinkType lt) {
		super("creation-page1", "Create a new folder content exporter",
				"Create a new folder content exporter", "", false, 3);
		this.parent = parent;
		this.it = it;
		this.lt = lt;
		this.__short_name__ = createInternalNameField();
		this.fieldExportedFolder = createFieldExportedFolder();
		this.fieldTypes = createFieldTypes();
		setActionPage(null);
		addLast(this.__short_name__, this.fieldExportedFolder, this.fieldTypes);

		registerListener();
	}

	@Override
	protected void registerListener() {
		super.registerListener();
		// add init and register
	}

	/**
	 * @generated
	 */
	public DTextUI createFieldExportedFolder() {
		return new DTextUI(
				CopyComposerCST.FILE_REF_EXPORTER_at_EXPORTED_FOLDER,
				"Folder to export", EPosLabel.left, new MC_AttributesItem(),
				null, 1, "", false, false, false);
	}

	/**
	 * @generated
	 */
	@Override
	public DListUI createFieldTypes() {
		MC_DefaultForList mc = new MC_DefaultForList(1, -1);
		IC_DefaultForList ic = new IC_DefaultForList("add a type.",
				"the string represent a exported type.", false);
		return new DListUI(CadseGCST.EXPORTER_at_TYPES, "content types",
				EPosLabel.top, mc, ic, true, false, false, false);
	}

}
