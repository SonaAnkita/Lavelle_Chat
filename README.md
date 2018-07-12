# Lavelle_Chat
It is really usual to have a chatting application for those people who can read and write in English. But, what about them who can never communicate by writing or 
maybe cannot read the message but can understand it provided there was a convertor cum translator for them. This project comes up with a text convertor or voice 
convertor for this particular set of people. A text convertor can help in converting a text into a voice message and a voice convertor is the vice-versa. It is an 
attempt in only language- English and can be implemented in the future as well with better prospectives of the same feature.

# # Features
There are mainly three features-
 # Conversion of text to speech (speech can be sent)
 # Conversion of voice to text (text can be sent)
 # Chat Bot (This helps in conversing about the necessary requirements ranging within a wideset of population with a virtual assistant)- this is a simple attempt at
   how to go about it.

# # Design 
  # Api for importing the assets of a chat bot 
   Link- http://developer.simsimi.com/v2config?aid=25457
   App Name :
    Lavelle_Chat
   Category :
    Trial
    Key :
    9ccfb3bb-9e19-4139-a8e9-e29105fe06f9
    Created :
    Wed Jul 11 17:41:27 UTC 2018 

 (Will be better if there is a paid API Key for this. This was a trial one)

  # Background design of the Activity (XML) is by (Adobe Photoshop CS6).

# # Tools or Prerequisites 
  # Android SDK v26 (Android Studio v3.0.1
  # Latest Android Build Tools
  # Android Support Repository

# # Implementation Details 
  # This application has a Chat Bot implemented using Simsimi mode Developer. The API Key has been taken from here for the implementation.
    One has to first register or sign up in the link- http://developer.simsimi.com/login 
    Two API keys - 1) Free Trial 2)Paid Key ( Here free trial one is used) 
    
  # Implemented Functions -
    # TexttoSpeech()- inbuilt Function
    # promptSpeechInput() - user built function
    # onActivityResult() - user built function
  
  # Implemented Packages-
    # Adapter - consists of CustomAdapter Class
    # Helper  - consists of HttpDataHandler Class
    # Models  - consists of ChatMode and SimsimiMode Classes
    # Floating Action Button 

  # Libraries 
    # Gson is another popular choice and being a smaller library than Jackson, you might prefer it to avoid 65k methods limitation. (v2.8.0)
    # GitHub (BubbleView v1.0.1)
    # Android Support (v26.1.0)

# # Code Structure 
  #  Layout XMLs are codes
  #  A modular code
  #  Uses in built functions when necessary. It also has user built functions and packages on the unavailability in the tool.

