import ProjectList from "../List";
import {ProjectInfo} from "../../../model/ProjectInfo";
import {shallowMount} from "@vue/test-utils";

const APP_CONTAINER_ID = "app-container"
describe('Project info', () => {
    const axios = require("axios");
    const MockAdapter = require("axios-mock-adapter");
    const Vue = require("vue")
    test('when no project then #project-list-table is empty', () => {
        document.body.insertAdjacentHTML('beforebegin', `<div id="${APP_CONTAINER_ID}"/>`)

        const table = shallowMount(ProjectList, {
            propsData: { containerId: 'app-container' }
        }).find('#project-list-table').findAll('tbody tr')

        expect(table.length).toBe(0)
    })
    test('when projects loaded then projects visible on list', async () => {
        const mock = new MockAdapter(axios);

        mock.onGet("/projects")
            .reply(200,
                [ new ProjectInfo(1, 'Energeia', 'Aplikacja do sprzedaży polis.') ]
            );

        document.body.insertAdjacentHTML('beforebegin', `<div id="${APP_CONTAINER_ID}"/>`)

        const wrapper = shallowMount(ProjectList, {
            propsData: { containerId: 'app-container' }
        })

        await wrapper.vm.$nextTick();
        await wrapper.vm.$nextTick();

        const rows = wrapper.find('#project-list-table')
        console.log(rows.element.innerHTML)
        //expect(table.length).toBe(0)
    })
})
