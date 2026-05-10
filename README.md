# Ecliptic Seasons - Pam's Harvestcraft 2 Compat

> Makes [Pam's Harvestcraft 2](https://www.curseforge.com/minecraft/mc-mods/pams-harvestcraft-2-crops) crops and trees respect [Ecliptic Seasons](https://www.curseforge.com/minecraft/mc-mods/ecliptic-seasons)! Otherwise, Pam's crops, saplings, and fruit blocks aren't season locked and grow all-year-round.  
> This is NOT for compat with Serene Seasons.

This is a largely data-based mod, providing JSON tag data for **crops & saplings**. **Fruit blocks** require a minor mixin into Pam's Harvestcraft to signal for CropGrowEvents. This is harmless but a config toggle is provided (`fruitMixinEnabled`, default `true`).

---

## Features

All of Pam's HC2 crops, saplings, and fruit blocks are:

- **Season-locked**: only grow in their fertile seasons.
- **Humidity-classified**: each block has a preferred biome humidity range (arid / dry / average / moist). ES applies a forgiving falloff in non-ideal biomes, so nothing's hard-locked. Out-of-range crops just grow more slowly.

---

## Requirements

- Minecraft **1.20.1**, Forge **47.4+**
- [Ecliptic Seasons](https://www.curseforge.com/minecraft/mc-mods/ecliptic-seasons) **0.13+**
- [Pam's Harvestcraft 2: Crops](https://www.curseforge.com/minecraft/mc-mods/pams-harvestcraft-2-crops) and/or [Pam's Harvestcraft 2: Trees](https://www.curseforge.com/minecraft/mc-mods/pams-harvestcraft-2-trees). Both are optional. If you don't have either, the mod does nothing.

---

## FAQ

**Other MC versions?** Just 1.20.1 for now. I'm one guy. If you would like to request another version and there is enough demand, I will do it if I have time.

**Can I fork / port / include in a modpack?** Yes, no need to ask, but a courtesy heads-up is always appreciated ^^

**Issues / suggestions:** report them on the [GitHub issue tracker](https://github.com/pwazta/Ecliptic-Seasons-Pams-Harvestcraft-2-Compat/issues) please.

---

## Credits & License

The season classifications (what seasons a crop should be able to grow in) are based on these MIT-licensed projects by **[Darkorg69](https://github.com/darkorg69)**:

- [serene-seasons-pams-harvestcraft-2-crops-compat](https://github.com/darkorg69/serene-seasons-pams-harvestcraft-2-crops-compat)
- [serene-seasons-pams-harvestcraft-2-trees-compat](https://github.com/darkorg69/serene-seasons-pams-harvestcraft-2-trees-compat)

Copyright notices preserved in [LICENSE](LICENSE).

**[Ecliptic Seasons](https://github.com/joe-vettek/Ecliptic-Seasons)** by joe_vettek, Sam_Chai, RoitoLeonine. The seasons mod this targets.

**[Pam's Harvestcraft 2](https://www.curseforge.com/minecraft/mc-mods/pams-harvestcraft-2-crops)** by Pam Weiland (MatrexsVigil). The underlying mod whose blocks we're season-locking.

**License: MIT.** Full terms in [LICENSE](LICENSE).