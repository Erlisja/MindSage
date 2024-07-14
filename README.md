# Mind Sage Project

## Introduction

Mind Sage is a mental health chatbot application designed to provide users with reliable information and support on mental health topics. The app leverages advanced AI capabilities to ensure contextually accurate and relevant responses to user queries.

## Features

- **Real-time Mental Health Support**: Provides immediate responses to mental health-related questions.
- **User-friendly Interface**: Designed with an intuitive and easy-to-use interface.
- **AI Integration**: Uses the Ollama AI model for generating responses.
- **Prompt Engineering**: Fine-tuned to ensure the chatbot focuses exclusively on mental health topics.

## Getting Started

### Prerequisites

- **Android Studio**: To build and run the application.
- **Ollama**: To be installed and configured locally.
- **Java Development Kit (JDK)**: Ensure you have the correct version installed.

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Erlisja/MindSage.git
   cd MindSage

## Open in Android Studio

1. Open Android Studio.
2. Select `File > Open` and navigate to the cloned directory.
3. Open the project.

## Set Up Ollama Locally

1. Download and install Ollama from the official website: [Ollama Download](https://ollama.ai/download)
2. Follow the installation instructions for your operating system.
3. Ensure Ollama is running locally.

## Configure API Endpoint

1. Ensure the local server API for Ollama is up and running.
2. Update the API endpoint in your project configuration to point to the local instance of Ollama.


### Permissions

Ensure the following permissions are added to your `AndroidManifest.xml`:

## Running the Application
Open Android Studio and connect your Android device or start an emulator.
Click on the Run button in Android Studio.
The application should build and deploy to your device/emulator.

## Usage
Once the application is running, you can start interacting with the chatbot. Simply type your mental health-related queries into the chat interface, and the chatbot will respond with relevant information and support.

## Technical Details
Backend Integration
The backend system is designed to handle user requests efficiently, utilizing the Ollama AI model for generating responses. The OllamaClient class is responsible for interacting with the local server API of Ollama.

## Prompt Engineering
The chatbot is fine-tuned using prompt engineering techniques to ensure responses are relevant and accurate. Prompts are designed to cover various aspects of mental health, and the model is continuously evaluated and improved based on user feedback.

## Future Improvements
We have several exciting features planned for future releases of Mind Sage:


1. Login and Sign-Up Pages:
  -Implementing user authentication to provide a personalized experience.
2. Menu Bar: Adding a menu bar where users can find:
3. Emergency Contacts: Quick access to important emergency contacts.
4. Saved Daily Affirmations: Allowing users to save and access daily affirmations.

## Video Demo

Here's a video / GIF that demos all of the app's implemented features:
<img src='https://www.dropbox.com/scl/fi/9qjdjzaxlobddkedtt1hm/Demo.gif?rlkey=1norwun62jh8mq7v1sp6uflu0&st=bq1t9ic2&dl=0.gif' title = 'Video Demo' width='' alt='Video Demo' />


![Demo1](https://github.com/user-attachments/assets/d5b313c4-aa9a-4d52-949d-68cbeb13bcba)




## Contributing
Contributions are welcome! Please read the CONTRIBUTING.md file for more information on how to get started.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
