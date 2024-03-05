# Changelog

## 1.2.0

Suppress OpenGL error #2.

Thank you [@nijahplays](https://github.com/AdamRaichu/suppress-OpenGL-1280/issues/3) for requesting suppression for 2.

Change mod name to `Suppress OpenGL Errors`.

## 1.1.1

Change mod name to `Suppress OpenGL Error 128(0-2)`.

## 1.1.0

Now suppresses 1281 and 1282 as well, but error suppression can be configured for each error using cloth config.

(Mod Menu integration is supported.)

Thank you [@shad0wolf0](https://github.com/AdamRaichu/suppress-OpenGL-1280/issues/1) for requesting suppression for 1281 and 1282.

## 1.0.0

First working version.
The first time the error is detected, the mod's warning message is logged, then the original error is logged.
All subsequent OpenGL errors with the id `1280` are cancelled before logging.
