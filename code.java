class FakeNewsDetector {
    constructor() {
      this.fakeNewsKeywords = [
        "shocking", "you won't believe", "conspiracy", "secret", "cover-up",
        "what they don't want you to know", "miracle cure", "clickbait"
      ];
    }
  
    /**
     * 
     */
    analyzeText(text) {
      const lowercaseText = text.toLowerCase();
      const matchedKeywords = this.fakeNewsKeywords.filter(keyword => 
        lowercaseText.includes(keyword.toLowerCase())
      );
  
      const score = matchedKeywords.length / this.fakeNewsKeywords.length;
  return {
        isFakeNews: score > 0.3,
        confidenceScore: score,
        matchedKeywords: matchedKeywords
      };
    }
  }
  
  // Test the fake news detector
  const detector = new FakeNewsDetector();
  
  const testCases = [
    "Breaking: Scientists discover a miracle cure for all diseases!",
    "Local community comes together to clean up neighborhood park",
    "You won't believe what this celebrity did! Shocking conspiracy revealed!",
    "New study shows benefits of regular exercise and balanced diet",
    "Secret government cover-up exposed! What they don't want you to know!"
  ];
  
  testCases.forEach((testCase, index) => {
    console.log(`Test Case ${index + 1}:`);
    console.log(`Text: "${testCase}"`);
    const result = detector.analyzeText(testCase);
    console.log(`Is Fake News: ${result.isFakeNews}`);
    console.log(`Confidence Score: ${result.confidenceScore.toFixed(2)}`);
    console.log(`Matched Keywords: ${result.matchedKeywords.join(", ")}`);
    console.log("---");
  });