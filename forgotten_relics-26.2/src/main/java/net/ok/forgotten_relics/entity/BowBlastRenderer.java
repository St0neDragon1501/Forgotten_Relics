package net.ok.forgotten_relics.entity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;

public class BowBlastRenderer extends EntityRenderer<BowBlast, EntityRenderState> {

    private final BowBlastModel model;

    public BowBlastRenderer(EntityRendererProvider.Context context) {
        super(context);

        this.model = new BowBlastModel(
                context.bakeLayer(BowBlastModel.LAYER_LOCATION)
        );
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    @Override
    public void submit(
            EntityRenderState state,
            PoseStack poseStack,
            SubmitNodeCollector collector,
            CameraRenderState cameraState
    ) {
        super.submit(state, poseStack, collector, cameraState);

        poseStack.pushPose();

        poseStack.translate(0.0F, 0.5F, 0.0F);

        model.setupAnim(state);

        poseStack.popPose();
    }
}