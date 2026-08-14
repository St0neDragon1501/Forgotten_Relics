package net.ok.forgotten_relics.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.Identifier;

public class BowBlastProjectileRenderer
        extends ArrowRenderer<BowBlastProjectileEntity, ArrowRenderState> {

	
	//this is what tell them to look for teture
    private static final Identifier TEXTURE =
            Identifier.parse("forgotten_relics:textures/entity/projectiles/bow_blast.png");

    
    public BowBlastProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    //what shape the entity is in
    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }

    //this tells them where to look for where to look for the tenture
    @Override
    public Identifier getTextureLocation(ArrowRenderState state) {
        return TEXTURE;
    }
}