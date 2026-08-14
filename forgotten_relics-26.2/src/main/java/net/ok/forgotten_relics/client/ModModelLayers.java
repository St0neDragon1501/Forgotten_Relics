package net.ok.forgotten_relics.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import net.ok.forgotten_relics.ForgottenRelics;

public class ModModelLayers {

    public static final ModelLayerLocation BOW_BLAST =
            new ModelLayerLocation(
                    Identifier.fromNamespaceAndPath(
                            ForgottenRelics.MODID,
                            "bow_blast"
                    ),
                    "main"
            );
}