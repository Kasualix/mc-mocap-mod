# About
**Motion Capture Mod (mocap)** is a Minecraft mod that allows you to record and replay player movements. It is created mainly for people who want to create complex scenes in Minecraft without using real players.

It records:
- movements
- sprinting, jumping, swimming, sneaking
- swinging hands
- using items
- items in hands and armor
- states like being on fire, being invisible, or glowing

After you save recording, you can create a scene, to which you can add multiple recordings or other scenes, with parameters like player name, position offset, or start delay.

# How to use

- First, you need to start recording using ```/mocap recording start```. It will record all your movements or movements of a player given as an argument. 
- Then, you can stop recording using ```/mocap recording stop``` and save it with ```/mocap recording save <name>```.
- Use ```/mocap playing start <name>``` to play recording.
- You can also create scenes to which you can add multiple recordings or other scenes, with parameters like player name, position offset, or start delay.
- To create scene use ```/mocap scenes add <scene_name>```. Then, add your recording using ```/mocap scenes addTo <scene_name> <recording_name> [delay] [x_offset] [y_offset] [z_offset] [player_name]``` (you can skip arguments in square brackets if you want).
- To play scene use ```/mocap playing start .<scene_name>``` - you need to put a dot before the scene name.
- By putting a dot before name, when using ```/mocap scenes addTo (...)```, you can also add scenes to other scenes.

### Commands
```
/mocap recording [...] - Recording player movements
/mocap scenes [...] - Creating and modifying scenes
/mocap playing [...] - Playing scens and recordings
/mocap info - Displays information about mod
/mocap help - Displays help message
```

# Example

### Simple example of one recording used 4 times in a scene with time and position offset

![](example.png)