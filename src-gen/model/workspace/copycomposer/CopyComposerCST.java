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
 * 
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
package model.workspace.copycomposer;

import java.util.UUID;

import fr.imag.adele.cadse.core.CadseRuntime;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.attribute.BooleanAttributeType;
import fr.imag.adele.cadse.core.attribute.StringAttributeType;

/**
 * @generated
 */
public class CopyComposerCST {
	/**
	 * @generated
	 */
	public static ItemType COPY_INTO_FOLDER_COMPOSER;
	/**
	 * @generated
	 */
	public static LinkType COPY_INTO_FOLDER_COMPOSER_lt_CONTENTS;
	/**
	 * @generated
	 */
	public static LinkType COPY_INTO_FOLDER_COMPOSER_lt_MANAGES_LT;
	/**
	 * @generated
	 */
	public final static String COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER = "targetFolder";
	/**
	 * @generated
	 */
	public static StringAttributeType COPY_INTO_FOLDER_COMPOSER_at_TARGET_FOLDER_;
	/**
	 * @generated
	 */
	public static ItemType FILE_REF_EXPORTER;
	/**
	 * @generated
	 */
	public static LinkType FILE_REF_EXPORTER_lt_CONTENTS;
	/**
	 * @generated
	 */
	public final static String FILE_REF_EXPORTER_at_EXPORTED_FOLDER = "exportedFolder";
	/**
	 * @generated
	 */
	public static StringAttributeType FILE_REF_EXPORTER_at_EXPORTED_FOLDER_;
	/**
	 * @generated
	 */
	public static ItemType JAVA_REF_COMPOSER;
	/**
	 * @generated
	 */
	public static LinkType JAVA_REF_COMPOSER_lt_CONTENTS;
	/**
	 * @generated
	 */
	public final static String JAVA_REF_COMPOSER_at_FOLDER_CLASSES = "folder-classes";
	/**
	 * @generated
	 */
	public static StringAttributeType JAVA_REF_COMPOSER_at_FOLDER_CLASSES_;
	/**
	 * @generated
	 */
	public final static String JAVA_REF_COMPOSER_at_FOLDER_SOURCES = "folder-sources";
	/**
	 * @generated
	 */
	public static StringAttributeType JAVA_REF_COMPOSER_at_FOLDER_SOURCES_;
	/**
	 * @generated
	 */
	public final static String JAVA_REF_COMPOSER_at_HAS_ASPECT = "has-aspect";
	/**
	 * @generated
	 */
	public static BooleanAttributeType JAVA_REF_COMPOSER_at_HAS_ASPECT_;
	/**
	 * @generated
	 */
	public final static String JAVA_REF_COMPOSER_at_HAS_CLASSES = "has-classes";
	/**
	 * @generated
	 */
	public static BooleanAttributeType JAVA_REF_COMPOSER_at_HAS_CLASSES_;
	/**
	 * @generated
	 */
	public final static String JAVA_REF_COMPOSER_at_HAS_SOURCES = "has-sources";
	/**
	 * @generated
	 */
	public static BooleanAttributeType JAVA_REF_COMPOSER_at_HAS_SOURCES_;
	/**
	 * @generated
	 */
	public static ItemType JAVA_REF_EXPORTER;
	/**
	 * @generated
	 */
	public static LinkType JAVA_REF_EXPORTER_lt_CONTENTS;

	/**
	 * @generated
	 */
	public static UUID _CADSE_ID = java.util.UUID
			.fromString("ed66d226-9000-4ad1-8c17-8226489383ef");

	/**
	 * @generated
	 */
	public static CadseRuntime _CADSE;

	/**
	 * @generated
	 */
	public CopyComposerCST() {
	}

}
