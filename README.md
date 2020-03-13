# Blue Blooded
THIS IS A PROTOTYPE / HIGHSCHOOL PROJECT

A remake of Kingdom Come: Deliverance('s Skalitz chapter) in text based form for a school project.

Currently not implement are "dice roll" based combat, true interaction with NPCs, stats and skill (defense doesn't do anything yet), different paths to choose from (like choose your path books), etc.
The product here is a skeleton, and a base of inspiration for future products, and potentially a finished version of this project. Will require a complete code overhaul in order to achieve a proper state of playability.

During this journey I've learned a lot about game design, and got a really good idea of how I should implement objects, characters and the player itself. I did it completely wrong here, shown by the fact that unique characters require a ridiculous amount of code in the Main.java file, but I can use this new knowledge for future games I may or may not make. So at least there's a silver lining!







List of possible commands:
use, look, observe, open, close, take, inventory, equip, wear, wield, unequip, move, attack, talk


CAPITAL WORDS are key words that basically outline what you should type into the console.

Walkthrough:
You are woken up by your mom and are told to put on some clothes from your chest, go talk to your father at the smithy and 'avoid' the shady man at the town square.

TIP: Look, observe by itself will give you a list of everything you can interact with in the room
     Combining the command with an object in the room will give you more information about a specific object
     
LOOK will tell you that there's a Henry's chest and a Henry's mom in the room.
  
  You may "TALK TO HENRY'S MOM" if you'd like, or you can "OPEN HENRY'S CHEST" to access the contents inside
  Either "LOOK" or "LOOK + HENRY'S CHEST" will allow you to see the contents from the chest, you may then use "TAKE (object here)", to   grab the new items. For example: "TAKE GREEN SHIRT".
  
  You can then WEAR or EQUIP the new item. For example: "WEAR GREEN SHIRT". You may also see your inventory by typing "INVENTORY", this will show you what you currently have and what is equipped. (Unfortunately you cannot look at items in your inventory to see its information again).
  
  Once you're finished, you're expected to "MOVE to the SMITHY", and "TALK to HENRY'S DAD". You'll be given a set of tasks: get his hammer from KUNESH, who is at KUNESH'S HOUSE, and get COAL from the COAL MERCHANT. You can "MOVE to TOWN SQUARE" and "LOOK or OBSERVE" to see.
  
  You'll be told that you see COAL, a COAL MERCHANT, and a SHADY MAN.
  TALK to the COAL MERCHANT in order to initate dialogue where he will deliver COAL to your father upon giving him 10 groschen.
  TALK to the SHADY MAN to initiate a 'combat tutorial'.
    Agree to meet him at the TRAINING SQUARE, then MOVE to the TRAINING SQUARE.
    TALK to the SHADY MAN again and he'll ask you to TAKE and EQUIP the WOODEN SWORD and LEATHER BOOTS at the training field.
    TALK to the SHADY MAN again to enter combat, and ATTACK him three times to complete the tutorial.
 TIP: ATTACK does not require you to type in a target's name   
 
 Now, MOVE to KUNESH'S HOUSE and LOOK or OBSERVE. You'll be told that you see KUNESH and your DAD'S HAMMER. You may talk to KUNESH if you'd like, but you're expected to TAKE DAD'S HAMMER. He'll confront you then begin to attack you. You are now in combat.
 
Exchange blows with Kunesh by ATTACKing him, he will eventually give up and you'll now be able to take your DAD'S HAMMER without any issues.

The game should now end, as all tasks have been exhausted. You can do everything in whichever order you'd like, but this tutorial was meant to be straight forward. Thanks for playing Blue Blooded, a prototype, learning experience and framework for future projects!
 
