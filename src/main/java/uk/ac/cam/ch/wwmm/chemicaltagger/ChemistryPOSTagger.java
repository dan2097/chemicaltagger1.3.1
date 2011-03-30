package uk.ac.cam.ch.wwmm.chemicaltagger;




/**************************************************************
 * Converts string input into tokenised and tagged text.
 * 
 * Runs a tokenisers 4 taggers against the input:
 * - Spectra: recognises and pulls out spectra information. 
 * - OSCAR  : recognises chemical entities. 
 * - Regex  : recognises chemistry related words that are not
 * recognised by OSCAR . 
 * - OpenNLP: recognises common english parts of speech .
 * It then combines the output of OSCAR, Regex and OpenNLP
 * taggers and then performs postprocessing on tags
 * 
 * @author lh359, dmj30, dl387
 ***************************************************************/
public final class ChemistryPOSTagger {

	private OscarTagger oscarTagger;
	private RegexTagger regexTagger;
	private OpenNLPTagger openNLPTagger;
	private SpectraTagger spectraTagger;

	private boolean runSpectraTaggerFlag = false;
	/**************************************
	 * Private Singleton holder.
	 ***************************************/
	private static class TaggerHolder {
		private static final ChemistryPOSTagger INSTANCE = new ChemistryPOSTagger();
	}
	/**************************************
	 * @return ChemistryPOSTaggerInstance
	 ***************************************/
	public static ChemistryPOSTagger getInstance() {
		return TaggerHolder.INSTANCE;
	}
	/**************************************
	 * Private Constructor Class.
	 ***************************************/
	private ChemistryPOSTagger() {
		oscarTagger = new OscarTagger();
		regexTagger = new RegexTagger();
		openNLPTagger = OpenNLPTagger.getInstance();
		spectraTagger = new SpectraTagger();
	}
	

	
	/**************************************
	 * Setter method for runSpectraTagger.
	 * runSpectraTagger is set to false by
	 * default because of memory issues.
	 * @param runSpectraTagger (boolean)
	 ***************************************/
	public void setRunSpectraTaggerFlag(boolean runSpectraTagger) {
		this.runSpectraTaggerFlag = true;
	}
	/**************************************
	 * Getter method for RegexTagger.
	 * @return regexTagger (RegexTagger)
	 ***************************************/
	public RegexTagger getRegexTagger() {
		return regexTagger;
	}

	/**************************************
	 * Setter method for RegexTagger.
	 * 
	 * @param regexTagger (RegexTagger)
	 ***************************************/
	public void setRegexTagger(final RegexTagger regexTagger) {
		this.regexTagger = regexTagger;
	}

	/**************************************
	 * Getter method for OscarTagger.
	 * @return oscarTagger (OscarTagger)
	 ***************************************/
	public OscarTagger getOscarTagger() {
		return oscarTagger;
	}
	/**************************************
	 * Setter method for OscarTagger.
	 * @param oscarTagger (OscarTagger)
	 ***************************************/
	public void setOscarTagger(final OscarTagger oscarTagger) {
		this.oscarTagger = oscarTagger;
	}

	/**************************************
	 * Getter method for OpenNLPTagger.
	 * @return openNLPTagger (OpenNLPTagger)
	 ***************************************/
	public OpenNLPTagger getOpenNLPTagger() {
		return openNLPTagger;
	}
	
	/**************************************
	 * Setter method for OpenNLPTagger.
	 * @param openNLPTagger (OpenNLPTagger)
	 ***************************************/
	public void setOpenNLPTagger(final OpenNLPTagger openNLPTagger) {
		this.openNLPTagger = openNLPTagger;
	}
	



	/*****************************************************
	 * Overloading Method for runTaggers with prioritiseOscar
	 * set to True.
	 * 
	 * @param inputSentence(String)
	 * @return POSContainer
	 *****************************************************/
	public POSContainer runTaggers(final String inputSentence) {
		return runTaggers(inputSentence,false);
	}
	
	/*****************************************************
	 * Runs Tokeniser and Taggers on the inputSentence
	 * and returns a POSContainer object.
	 * Prioritises OSCAR tags if prioritiseOscar is True
	 * else it prioritises regexTagger.
	 *****************************************************/
	public POSContainer runTaggers(String inputSentence,final boolean prioritiseOscar) {

		
		POSContainer posContainer = new POSContainer();
		inputSentence = Formatter.normaliseText(inputSentence);
		posContainer.setInputText(inputSentence);
		if (runSpectraTaggerFlag){
		posContainer = spectraTagger.runTagger(posContainer);
		}
		posContainer = oscarTagger.runTokeniser(posContainer);
		posContainer = oscarTagger.runTagger(posContainer);
		posContainer = regexTagger.runTagger(posContainer);
		posContainer = openNLPTagger.runTagger(posContainer);

		posContainer.setPrioritiseOscar(prioritiseOscar);
		posContainer.combineTaggers();	
		posContainer.recombineHyphenedTokens();
		posContainer =  new PostProcessTags().correctCombinedTagsList(posContainer);
		return posContainer;
	}
		
		
}
