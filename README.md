# teller

Spigot-Plugin message providing system written in Kotlin

## Usage

Create an instance of `PropertiesMessageProvider` using the Constructor with an instance of Properties or the `fromPlugin` factory method which takes an instance of JavaPlugin and an resourcePath String, where you pass the path to the message properties resource.

```kotlin
MessageProvider provider = PropertiesMessageProvider(this, "i18n/messages.properties")
```

Then use the `provide` method to get an instance of Message using your message key.

```kotlin
Message helloMessage = provider.provide("hello")
```

You can append other messages and/or add the prefix (which needs to have the key `prefix` in your properties file).


```kotlin
Message combinedMessage = helloMessage.append(provider.provide("world")).prefixed()
```

You can send this message either via the `send(CommandSender)` method or the method extension `sendMessage(Message)` of CommandSender.

```kotlin
combinedMessage.send(recepient)
// or
recepient.sendMessage(combinedMessage)
```
