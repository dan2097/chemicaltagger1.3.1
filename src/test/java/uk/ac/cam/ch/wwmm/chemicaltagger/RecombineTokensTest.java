package uk.ac.cam.ch.wwmm.chemicaltagger;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/************************************
 * Tests the RecombineTokens Class.
 * @author lh359
 ************************************/
public class RecombineTokensTest {

	private static OscarTagger oscarTagger;
	private static RegexTagger regexTagger;
	private static OpenNLPTagger openNLPTagger;
	private static OscarTokeniser oscarTokeniser;
	@BeforeClass
	public static void setup(){
		ChemistryPOSTagger posTagger = ChemistryPOSTagger.getDefaultInstance();
		oscarTokeniser = posTagger.getOscarTokeniser();
		oscarTagger = posTagger.getOscarTagger();
		regexTagger = posTagger.getRegexTagger();
		openNLPTagger = posTagger.getOpenNLPTagger();
	    
	}
	
	@AfterClass
	public static void cleanUp(){
		oscarTokeniser = null;
		oscarTagger = null;
		regexTagger = null;
		openNLPTagger = null;
	}
	
	@Test
	public void testRecombineSentence1() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/sentence1.txt");
		String expectedOutput = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/ref1.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		posContainer = regexTagger.runTagger(posContainer);
		posContainer = openNLPTagger.runTagger(posContainer);
		posContainer.combineTaggers();
		int beforeRecombined = posContainer.getCombinedTagsList().size();
		posContainer = RecombineTokens.recombineHyphenedTokens(posContainer);
		int afterRecombined = posContainer.getCombinedTagsList().size();
		Assert.assertNotSame("Different Size of combined List",
				beforeRecombined, afterRecombined);
		Assert.assertEquals("Combined all the hyphenated words",expectedOutput, posContainer.getTokenTagTupleAsString());

	}

	@Test
	public void testRecombineSentence2() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/sentence2.txt");
		String expectedOutput = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/ref2.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		posContainer = regexTagger.runTagger(posContainer);
		posContainer = openNLPTagger.runTagger(posContainer);
		posContainer.combineTaggers();
		int beforeRecombined = posContainer.getCombinedTagsList().size();
		posContainer = RecombineTokens.recombineHyphenedTokens(posContainer);
		int afterRecombined = posContainer.getCombinedTagsList().size();
		Assert.assertNotSame(beforeRecombined, afterRecombined);
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		Assert.assertEquals("Combined all the hyphenated words",expectedOutput, posContainer.getTokenTagTupleAsString());
	}
	
	@Test
	public void testRecombineSentence3() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/sentence3.txt");
		String expectedOutput = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/ref3.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		posContainer = regexTagger.runTagger(posContainer);
		posContainer = openNLPTagger.runTagger(posContainer);
		posContainer.combineTaggers();
		int beforeRecombined = posContainer.getCombinedTagsList().size();
		posContainer = RecombineTokens.recombineHyphenedTokens(posContainer);
		int afterRecombined = posContainer.getCombinedTagsList().size();
		Assert.assertNotSame(beforeRecombined, afterRecombined);
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		Assert.assertEquals("Combined all the hyphenated words",expectedOutput, posContainer.getTokenTagTupleAsString());
	}



	@Test
	public void testRecombineSentence4() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/sentence4.txt");
		String expectedOutput = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/ref4.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		posContainer = regexTagger.runTagger(posContainer);
		posContainer = openNLPTagger.runTagger(posContainer);
		posContainer.combineTaggers();
		int beforeRecombined = posContainer.getCombinedTagsList().size();
		posContainer = RecombineTokens.recombineHyphenedTokens(posContainer);
		int afterRecombined = posContainer.getCombinedTagsList().size();
		Assert.assertNotSame(beforeRecombined, afterRecombined);
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		Assert.assertEquals("Combined all the hyphenated words",expectedOutput, posContainer.getTokenTagTupleAsString());
	}

	@Test
	public void testRecombineSentence5() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/sentence5.txt");
		String expectedOutput = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/ref5.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		posContainer = regexTagger.runTagger(posContainer);
		posContainer = openNLPTagger.runTagger(posContainer);
		posContainer.combineTaggers();
		int beforeRecombined = posContainer.getCombinedTagsList().size();
		posContainer = RecombineTokens.recombineHyphenedTokens(posContainer);
		int afterRecombined = posContainer.getCombinedTagsList().size();
		Assert.assertNotSame(beforeRecombined, afterRecombined);
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		Assert.assertEquals("Combined all the hyphenated words",expectedOutput, posContainer.getTokenTagTupleAsString());
	}
	
	
	
	@Test
	public void testOxidationRecombineSentence() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/oxidation.txt");
		String expectedOutput = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/oxidationRef.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		posContainer = regexTagger.runTagger(posContainer);
		posContainer = openNLPTagger.runTagger(posContainer);
		posContainer.combineTaggers();
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		Assert.assertEquals("Combined all the hyphenated words",expectedOutput, posContainer.getTokenTagTupleAsString());
	}
	
	@Test
	public void testForMissingInput1() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/missingInput1.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
		posContainer = regexTagger.runTagger(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
		posContainer = openNLPTagger.runTagger(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
		posContainer.combineTaggers();
		posContainer = RecombineTokens.recombineHyphenedTokens(posContainer);
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
	

	}
	@Test
	public void testForMissingInput2() {
		POSContainer posContainer = new POSContainer();
		String inputSentence = Utils.readSentence("uk/ac/cam/ch/wwmm/chemicaltagger/recombineTokens/missingInput2.txt");
		inputSentence = Formatter.normaliseText(inputSentence);
        posContainer.setInputText(inputSentence);
		posContainer = oscarTokeniser.tokenise(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
		posContainer = regexTagger.runTagger(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
		posContainer = openNLPTagger.runTagger(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
		posContainer.combineTaggers();
		posContainer = RecombineTokens.recombineHyphenedTokens(posContainer);
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		Assert.assertEquals(inputSentence.toLowerCase().replace(" ", ""),StringUtils.join(posContainer.getWordTokenList().listIterator(),"").toLowerCase());
	}
}
