package net.ok.forgotten_relics.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;

import net.ok.forgotten_relics.client.ModModelLayers;

public class BowBlastProjectileRenderer<T extends AbstractArrow, S extends BowBlastRenderState>
        extends EntityRenderer<T, S> {

    private final BowBlastModel model;

    public BowBlastProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);

        this.model = new BowBlastModel(
        	    context.bakeLayer(ModModelLayers.BOW_BLAST)
        	);
    }

    @Override
    public S createRenderState() {
        return (S) new BowBlastRenderState();
    }

    public void submit(
            S state,
            PoseStack poseStack,
            SubmitNodeCollector submitNodeCollector,
            CameraRenderState camera
    ) {
        poseStack.pushPose();

        poseStack.mulPose(
                Axis.YP.rotationDegrees(state.yRot - 90.0F)
        );

        poseStack.mulPose(
                Axis.ZP.rotationDegrees(state.xRot)
        );

        submitNodeCollector.submitModel(
                this.model,
                state,
                poseStack,
                this.getTextureLocation(state),
                state.lightCoords,
                OverlayTexture.NO_OVERLAY,
                state.outlineColor,
                null
        );

        poseStack.popPose();

        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    
    protected Identifier getTextureLocation(S state) {
        return Identifier.parse(
                "forgotten_relics:textures/entity/projectiles/bow_blast.png"
        );
    }

    public void extractRenderState(
            T entity, S state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.xRot = entity.getXRot(partialTicks);
        state.yRot = entity.getYRot(partialTicks);
        state.shake = entity.shakeTime - partialTicks;
        }
    
}
    
