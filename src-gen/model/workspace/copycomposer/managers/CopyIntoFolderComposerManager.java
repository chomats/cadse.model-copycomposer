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

import java.util.Collection;
import java.util.List;

import model.workspace.copycomposer.CopyComposerCST;
import fr.imag.adele.cadse.cadseg.managers.build.composer.EclipseComposerManager;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;

/**
 * @generated
 */
public class CopyIntoFolderComposerManager extends EclipseComposerManager {

	public CopyIntoFolderComposerManager() {
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
	public static final String getTargetFolderAttribute(final Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getAttributeWithDefaultValue(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER_, null);
	}

	/**
	 * @generated
	 */
	public static final void setTargetFolderAttribute(final Item copyIntoFolderComposer, final String value) {
		try {
			copyIntoFolderComposer.setAttribute(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER_, value);
		} catch (Throwable t) {

		}
	}

	/**
	 * get links 'managesLT' from 'CopyIntoFolderComposer' to 'Link'.
	 * 
	 * @generated
	 */
	static public List<Link> getManagesLTLink(final Item copyIntoFolderComposer) {
        return copyIntoFolderComposer.getOutgoingLinks(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT);
    }

	/**
	 * @generated
	 */
	static public Collection<Item> getManagesLTAll(final Item copyIntoFolderComposer) {
        return copyIntoFolderComposer.getOutgoingItems(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT, false);
    }

	/**
	 * @generated
	 */
	static public Collection<Item> getManagesLT(final Item copyIntoFolderComposer) {
        return copyIntoFolderComposer.getOutgoingItems(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT,true);
    }

	/**
	 * @generated
	 */
	static public void addManagesLT(final Item copyIntoFolderComposer, final Item value) throws CadseException {
        copyIntoFolderComposer.addOutgoingItem(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT,value);
    }

	/**
	 * @generated
	 */
	static public void removeManagesLT(final Item copyIntoFolderComposer, final Item value) throws CadseException {
        copyIntoFolderComposer.removeOutgoingItem(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT,value);
    }

	/**
		get a link 'contents' from 'CopyIntoFolderComposer' to 'ContentItem'.
		@generated
	*/
	static public Link getContentsLink(Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getOutgoingLink(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_CONTENTS);
	}

	/**
		get all link destination 'contents' from 'CopyIntoFolderComposer' to 'ContentItem'.
		@generated
	*/
	static public Item getContentsAll(Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getOutgoingItem(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_CONTENTS, false);
	}

	/**
		get resolved link destination 'contents' from 'CopyIntoFolderComposer' to 'ContentItem'.
		@generated
	*/
	static public Item getContents(Item copyIntoFolderComposer) {
		return copyIntoFolderComposer.getOutgoingItem(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_CONTENTS, true);
	}

	/**
		set a link 'contents' from 'CopyIntoFolderComposer' to 'ContentItem'.
		@generated
	*/
	static public void setContents(Item copyIntoFolderComposer, Item value) throws CadseException {
		copyIntoFolderComposer.setOutgoingItem(CopyComposerCST.COPY_INTO_FOLDER_COMPOSER_lt_CONTENTS,value);
	}
}
