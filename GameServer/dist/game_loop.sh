#!/bin/bash

err=1
until [ $err == 0 ];
do
	java -server -Xms128m -Xmx1536m -ea -Xbootclasspath/p:./libs/jsr166.jar -cp ./libs/*:ae-game-1.0.1.jar com.aionengine.gameserver.GameServer > log/stdout.log 2>&1
	err=$?
	sleep 10
done