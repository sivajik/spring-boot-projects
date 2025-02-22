const ChatResponse = ({ response }) => {
  if (!response) {
    return null;
  }

  const { candidates, usageMetadata } = response;
  
  return (
    <div className="container my-4">
      <h3>Response</h3>
      {candidates.map((candidate, index) => (
        <div className="card mb-3" key={index}>
          <div className="card-body">            
            <p className="card-text">{candidate.content.parts[0].text}</p>
                      
          </div>
        </div>
      ))}

      <h4>Usage Metadata</h4>
      <p>Total Tokens: {usageMetadata.totalTokenCount}</p>
      <p>Prompt Token Count: {usageMetadata.promptTokenCount}</p>
      <p>Candidates Token Count: {usageMetadata.candidatesTokenCount}</p>
    </div>
  );
};

/*
            <h6>Citations</h6>
            <ul>
              {candidate?.citationMetadata?.citationSources.map(
                (source, idx) => (
                  <li key={idx}>
                    <a href="source.url" target="_">
                      {source.url}
                    </a>{" "}
                    (Indexes: {source.startIndex} - {source.endIndex})
                  </li>
                )
              )}
            </ul>
*/
export default ChatResponse;
