/**
 * 
 */
package model.workspace.copycomposer.managers;

import java.util.List;

import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.Validator;

public class JavaRefComposerValidator implements Validator {
@Override
public List<Item> validate(final Item item, final ProblemReporter reporter) {
	final boolean has_sources = JavaRefComposerManager.hasSources(item);
	final boolean has_classes = JavaRefComposerManager.hasClasses(item);
	final boolean has_aspects = JavaRefComposerManager.hasAspects(item);

	if (!has_aspects && !has_classes && !has_sources) {
		reporter.error(item, 1, "Le composer doit avoir au moins un de ses flags � vrai");
	}

	return null;
}

@Override
public Class<Validator> getClassAdapt() {
	return Validator.class;
}
}