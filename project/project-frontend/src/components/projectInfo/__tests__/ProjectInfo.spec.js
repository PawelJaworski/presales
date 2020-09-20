import ProjectInfo from "../Info.vue";
import {shallowMount} from "@vue/test-utils";

const APP_CONTAINER_ID = "app-container"
describe('Project info', () => {
    test('should init', () => {
        document.body.insertAdjacentHTML('beforebegin', `<div id="${APP_CONTAINER_ID}"/>`)

        const wrapper = shallowMount(ProjectInfo, {
            propsData: { containerId: 'app-container' }
        })
        expect(wrapper.text()).toMatch("Waiting")
    })
    test('should update on PROJECT_SELECTED', async () => {
        document.body.insertAdjacentHTML('beforebegin', '<div id="app-container"/>')

        const wrapper = shallowMount(ProjectInfo, {
            propsData: { containerId: APP_CONTAINER_ID }
        })

        const appContainerEl = document.getElementById('app-container')
        await appContainerEl.dispatchEvent(new CustomEvent("PROJECT_SELECTED", {detail: "Project Info Updated"}))

        expect(wrapper.text()).toMatch("Project Info Updated")
    })
})
